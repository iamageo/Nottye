package com.iamageo.domain.repository

import com.iamageo.domain.model.Nottye
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNottyeRepository : NottyeRepository {

    private val nottyes = mutableListOf<Nottye>()

    override fun getAllNottyes(): Flow<List<Nottye>> {
        return flow { emit(nottyes) }
    }

    override suspend fun getNottyeById(id: Int): Nottye? {
        return nottyes.find { it.id == id }
    }

    override suspend fun insertNottye(nottye: Nottye) {
        nottyes.add(nottye)
    }

    override suspend fun deleteNottye(nottye: Nottye) {
        nottyes.remove(nottye)
    }

}