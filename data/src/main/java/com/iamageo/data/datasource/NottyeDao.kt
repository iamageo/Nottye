package com.iamageo.data.datasource

import androidx.room.*
import com.iamageo.domain.model.Nottye
import kotlinx.coroutines.flow.Flow

@Dao
interface NottyeDao {

    @Query("SELECT * FROM nottye")
    fun getAllNottyes() : Flow<List<Nottye>>

    @Query("SELECT * FROM nottye WHERE id = :id")
    suspend fun getNottyesById(id: Int) : Nottye?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNottye(nottye: Nottye)

    @Delete
    suspend fun deleteNottye(nottye: Nottye)

}