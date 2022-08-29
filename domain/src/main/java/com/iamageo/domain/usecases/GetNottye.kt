package com.iamageo.domain.usecases

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.repository.NottyeRepository

class GetNottye(
    private val repository: NottyeRepository
) {

    suspend operator fun invoke(id: Int): Nottye? {
        return repository.getNottyeById(id)
    }
}