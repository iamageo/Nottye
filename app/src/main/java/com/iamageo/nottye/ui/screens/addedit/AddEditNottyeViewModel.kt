package com.iamageo.nottye.ui.screens.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.domain.model.InvalidNottyeException
import com.iamageo.domain.model.Nottye
import com.iamageo.domain.usecases.NottyeUseCases
import com.iamageo.nottye.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNottyeViewModel @Inject constructor(
    private val nottyeUseCases: NottyeUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteColor = mutableStateOf(Utils.NottyeColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private var currentNoteId: Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _noteTitle = mutableStateOf(
        NottyeEditTextState(
            hint = "Enter title..."
        )
    )
    val noteTitle: State<NottyeEditTextState> = _noteTitle

    private val _noteContent = mutableStateOf(
        NottyeEditTextState(
            hint = "Enter some content"
        )
    )
    val noteContent: State<NottyeEditTextState> = _noteContent

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1) {
                viewModelScope.launch {
                    nottyeUseCases.getNottye(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = _noteContent.value.copy(
                            text = note.content,
                            isHintVisible = false
                        )
                        _noteColor.value = note.color
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditNottyeEvents) {
        when (event) {
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
            is AddEditNottyeEvents.SaveNote -> {
                viewModelScope.launch {
                    try {
                        nottyeUseCases.addNottye(
                            Nottye(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(UiEvents.SaveNottye)
                    } catch (e: InvalidNottyeException) {

                    }
                }
            }
        }
    }

    sealed class UiEvents() {
        data class ShowSnackbar(val message: String) : UiEvents()
        object SaveNottye : UiEvents()
    }

}
