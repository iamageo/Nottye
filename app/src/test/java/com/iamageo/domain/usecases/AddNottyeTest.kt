package com.iamageo.domain.usecases

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.FakeNottyeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class AddNottyeTest {

    private lateinit var nottye: AddNottye
    private lateinit var fakeNottyeRepository: FakeNottyeRepository

    @Before
    fun setUp() {
        fakeNottyeRepository = FakeNottyeRepository()
        nottye = AddNottye(fakeNottyeRepository)
    }

    @Test
    fun `insert nottye with empty title`() = runBlocking {

        val nottyeToInsert = Nottye(
            id = 0,
            title = "",
            content = "teste content",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.insertNottye(nottyeToInsert)

        fakeNottyeRepository.getAllNottyes()

        assertEquals(fakeNottyeRepository.getNottyeById(0)?.title, "")
    }

    @Test
    fun `insert nottye with empty content`() = runBlocking {

        val nottyeToInsert = Nottye(
            id = 0,
            title = "teste titulo",
            content = "",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.insertNottye(nottyeToInsert)

        fakeNottyeRepository.getAllNottyes()

        assertEquals(fakeNottyeRepository.getNottyeById(0)?.content, "")
    }

    @Test
    fun `insert nottye with title and content`() = runBlocking {

        val nottyeToInsert = Nottye(
            id = 0,
            title = "teste titulo",
            content = "teste content",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.insertNottye(nottyeToInsert)

        fakeNottyeRepository.getAllNottyes()

        assertNotEquals("", fakeNottyeRepository.getNottyeById(0)?.title)
        assertNotEquals("", fakeNottyeRepository.getNottyeById(0)?.content)
    }

}