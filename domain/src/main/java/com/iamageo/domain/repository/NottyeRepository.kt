package com.iamageo.domain.repository

import com.iamageo.domain.model.Nottye
import kotlinx.coroutines.flow.Flow


interface NottyeRepository {

    fun getAllNottyes() : Flow<List<Nottye>>

    suspend fun getNottyeById(id: Int) : Nottye?

    suspend fun insertNottye(nottye: Nottye)

    suspend fun deleteNottye(nottye: Nottye)

}