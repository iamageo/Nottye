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

    override suspend fun insertNottye(nottye: Nottye): Long {
        if (nottye.id == null) {
            val newId = (nottyes.maxOfOrNull { it.id ?: 0 } ?: 0) + 1
            nottyes.add(nottye.copy(id = newId))
            return newId.toLong()
        } else {
            nottyes.add(nottye)
            return nottye.id.toLong()
        }
    }

    override suspend fun deleteNottye(nottye: Nottye): Int {
        return if (nottyes.remove(nottye)) 1 else 0
    }

}
