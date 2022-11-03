package com.iamageo.domain.usecases

import com.google.common.truth.Truth.assertThat
import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.FakeNottyeRepository
import com.iamageo.domain.util.NoteOrder
import com.iamageo.domain.util.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNottyesTest {

    private lateinit var getNottyes: GetNottyes
    private lateinit var fakeNottyeRepository: FakeNottyeRepository

    @Before
    fun setUp() {
        fakeNottyeRepository = FakeNottyeRepository()
        getNottyes = GetNottyes(fakeNottyeRepository)

        val nottyesToInsert = mutableListOf<Nottye>()
        ('a'..'z').forEachIndexed { index, c ->
            run {
                nottyesToInsert.add(
                    Nottye(
                        title = c.toString(),
                        content = "this is a nottye test $index",
                        color = index,
                        timestamp = index.toLong()
                    )
                )
            }
        }
        nottyesToInsert.shuffle()
        runBlocking {
            nottyesToInsert.forEach { fakeNottyeRepository.insertNottye(it) }
        }
    }

    @Test
    fun `order nottyes by title ascending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Title(OrderType.Ascending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].title).isLessThan(nottyes[i + 1].title)
        }

    }

    @Test
    fun `order nottyes by title descending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Title(OrderType.Descending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].title).isGreaterThan(nottyes[i + 1].title)
        }

    }

    @Test
    fun `order nottyes by date ascending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Date(OrderType.Ascending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].timestamp).isLessThan(nottyes[i + 1].timestamp)
        }

    }

    @Test
    fun `order nottyes by date descending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Date(OrderType.Descending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].timestamp).isGreaterThan(nottyes[i + 1].timestamp)
        }

    }

    @Test
    fun `order nottyes by color ascending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Color(OrderType.Ascending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].color).isLessThan(nottyes[i + 1].color)
        }

    }

    @Test
    fun `order nottyes by color descending correct order`() = runBlocking {

        val nottyes = getNottyes(NoteOrder.Color(OrderType.Descending)).first()

        for (i in 0..nottyes.size - 2) {
            assertThat(nottyes[i].color).isGreaterThan(nottyes[i + 1].color)
        }

    }


}