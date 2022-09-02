package com.iamageo.nottye.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.iamageo.domain.usecases.NottyeUseCases

class NottyeViewModel(
    private val nottyeUseCases: NottyeUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NottyeStates())
    val state: State<NottyeStates> = _state

}