package com.iamageo.nottye.ui.screens.home

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.util.NoteOrder

sealed class NottyeEvents {
    data class Order(val noteOrder: NoteOrder) : NottyeEvents()
    object RestoreNottye : NottyeEvents()
    data class DeleteNottye(val nottye: Nottye) : NottyeEvents()
    object ToggleOrderSection : NottyeEvents()
}