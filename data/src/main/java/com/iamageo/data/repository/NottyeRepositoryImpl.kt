package com.iamageo.data.repository

import com.iamageo.data.datasource.NottyeDao
import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.NottyeRepository
import kotlinx.coroutines.flow.Flow

class NottyeRepositoryImpl(
    private val nottyeDao: NottyeDao
) : NottyeRepository {
    override fun getAllNottyes(): Flow<List<Nottye>> {
        return nottyeDao.getAllNottyes()
    }

    override suspend fun getNottyeById(id: Int): Nottye? {
        return nottyeDao.getNottyesById(id)
    }

    override suspend fun insertNottye(nottye: Nottye) {
        return nottyeDao.insertNottye(nottye = nottye)
    }

    override suspend fun deleteNottye(nottye: Nottye) {
        return nottyeDao.deleteNottye(nottye = nottye)
    }
}