package com.iamageo.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iamageo.domain.model.Nottye

@Database(
    entities = [Nottye::class],
    version = 1,
    exportSchema = false
)
abstract class NottyeDatabase : RoomDatabase() {

    abstract val nottyeDao: NottyeDao

    companion object {
        const val DATABASE_NAME = "nottye_db"
    }

}