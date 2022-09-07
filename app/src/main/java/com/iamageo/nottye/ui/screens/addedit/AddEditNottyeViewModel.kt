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

    private val _noteTitle = mutableStateOf(NottyeEditTextState(
        hint = "Enter title..."
    ))
    val noteTitle: State<NottyeEditTextState> = _noteTitle

    private val _noteContent = mutableStateOf(NottyeEditTextState(
        hint = "Enter some content"
    ))
    val noteContent: State<NottyeEditTextState> = _noteContent

    fun onEvent(event: AddEditNottyeEvents) {
        when(event) {
            is AddEditNottyeEvents.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNottyeEvents.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AddEditNottyeEvents.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is AddEditNottyeEvents.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContent.value.text.isBlank()
                )
            }
            is AddEditNottyeEvents.ChangeColor -> {
                _noteColor.value = event.color
            }
            else -> {}
        }
    }
}
