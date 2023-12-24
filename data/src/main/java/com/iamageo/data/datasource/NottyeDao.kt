package com.iamageo.data.datasource

import androidx.room.*
import com.iamageo.domain.model.Nottye
import kotlinx.coroutines.flow.Flow

@Dao
interface NottyeDao {

    @Query("SELECT * FROM nottye")
    fun getAllNottyes() : Flow<List<Nottye>>

    @Query("SELECT * FROM nottye WHERE id = :id")
    fun getNottyesById(id: Int) : Nottye?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNottye(nottye: Nottye) : Long

    @Delete
    fun deleteNottye(nottye: Nottye) : Int

}