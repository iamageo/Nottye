package com.iamageo.domain.usecases

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.FakeNottyeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetNottyeTest {

    private lateinit var getNottye: GetNottye
    private lateinit var fakeNottyeRepository: FakeNottyeRepository

    @Before
    fun sutUp() {

        fakeNottyeRepository = FakeNottyeRepository()
        getNottye = GetNottye(fakeNottyeRepository)


    }

    @Test
    fun `when get nottye by id`() = runBlocking {

        val nottyeToInsert = Nottye(
            id = 0,
            title = "teste titulo",
            content = "",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.insertNottye(nottyeToInsert)

        fakeNottyeRepository.getAllNottyes()

        Assert.assertEquals(fakeNottyeRepository.getNottyeById(0)?.id, 0)

    }

    @Test
    fun `when get nottye by id but dont exist`() = runBlocking {
        val nottyeToInsert = Nottye(
            id = 0,
            title = "teste titulo",
            content = "",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.insertNottye(nottyeToInsert)

        fakeNottyeRepository.getAllNottyes()

        Assert.assertEquals(fakeNottyeRepository.getNottyeById(1)?.id, null)

    }


}