package com.iamageo.nottye.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NottyeViewModel @Inject constructor() : ViewModel() {

    private val _state = mutableStateOf(NottyeStates())
    val state: State<NottyeStates> = _state

    fun onEvent(event: NottyeEvents) {
        when (event) {
            is NottyeEvents.ToggleOrderSection -> {
                _state.value =
                    state.value.copy(isOrderSectionVisible = !state.value.isOrderSectionVisible)
            }
        }
    }

}