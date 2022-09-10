package com.iamageo.domain.usecases

import com.iamageo.domain.model.InvalidNottyeException
import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.NottyeRepository

class AddNottye(
    private val repository: NottyeRepository
) {

    @Throws(InvalidNottyeException::class)
    suspend operator fun invoke(nottye: Nottye) {
        if (nottye.title.isBlank()) {
            throw InvalidNottyeException("The title of the nottye can't be empty.")
        }
        if (nottye.content.isBlank()) {
            throw InvalidNottyeException("The content of the nottye can't be empty.")
        }
        repository.insertNottye(nottye)
    }
}