package com.iamageo.domain.usecases

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.FakeNottyeRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DeleteNottyeTest {

    private lateinit var deleteNottye: DeleteNottye
    private lateinit var fakeNottyeRepository: FakeNottyeRepository

    @Before
    fun setUop() {
        fakeNottyeRepository = FakeNottyeRepository()
        deleteNottye = DeleteNottye(fakeNottyeRepository)
    }

    @Test
    fun `when delete nottye`() = runBlocking {

        val nottyeToInsert = Nottye(
            id = 0,
            title = "teste titulo",
            content = "",
            color = 0,
            timestamp = 0.toLong()
        )

        fakeNottyeRepository.deleteNottye(nottyeToInsert)

        val result = fakeNottyeRepository.getAllNottyes()

        Assert.assertEquals(result.toList().size, 1)

    }

}