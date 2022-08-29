package com.iamageo.domain.usecases

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.NottyeRepository

class DeleteNottye(
    private val repository: NottyeRepository
) {

    suspend operator fun invoke(nottye: Nottye) {
        repository.deleteNottye(nottye)
    }
}