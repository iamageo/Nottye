package com.iamageo.nottye.ui.screens.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.iamageo.nottye.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNottyeViewModel @Inject constructor() : ViewModel() {

    private val _noteColor = mutableStateOf(Utils.NottyeColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    fun onEvent(event: AddEditNottyeEvents) {
        when(event) {
            is AddEditNottyeEvents.ChangeColor -> {
                _noteColor.value = event.color
            }
            else -> {}
        }
    }
}
