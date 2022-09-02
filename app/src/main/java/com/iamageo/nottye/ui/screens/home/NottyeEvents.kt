package com.iamageo.nottye.ui.screens.home

import com.iamageo.domain.util.NoteOrder

sealed class NottyeEvents {
    data class Order(val noteOrder: NoteOrder) : NottyeEvents()
    object ToggleOrderSection : NottyeEvents()
}