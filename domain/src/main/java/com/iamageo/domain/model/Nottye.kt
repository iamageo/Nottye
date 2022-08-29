package com.iamageo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nottye(
    val title: String,
    val content: String,
    val timestamp: Long,
    val valcolor: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {

    }
}

class InvalidNoteException(message: String): Exception(message)