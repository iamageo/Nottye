package com.iamageo.nottye.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.domain.model.Nottye
import com.iamageo.domain.usecases.NottyeUseCases
import com.iamageo.domain.util.NoteOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NottyeViewModel @Inject constructor(
    private val nottyeUeCases: NottyeUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NottyeStates())
    val state: State<NottyeStates> = _state

    private var recentlyDeletedNote: Nottye? = null

    private var getNotesJob: Job? = null

    fun onEvent(event: NottyeEvents) {
        when (event) {
            is NottyeEvents.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNottyes(event.noteOrder)
            }
            is NottyeEvents.RestoreNottye -> {
                viewModelScope.launch {
                    nottyeUeCases.addNottye(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NottyeEvents.ToggleOrderSection -> {
                _state.value =
                    state.value.copy(isOrderSectionVisible = !state.value.isOrderSectionVisible)
            }
        }
    }

    private fun getNottyes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = nottyeUeCases.getNottyes(noteOrder).onEach { nottyes ->
            _state.value = state.value.copy(notes = nottyes, noteOrder = noteOrder)
        }.launchIn(viewModelScope)
    }

}