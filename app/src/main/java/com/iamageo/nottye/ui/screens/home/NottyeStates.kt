package com.iamageo.nottye.ui.screens.home

import com.iamageo.domain.model.Nottye
import com.iamageo.domain.util.NoteOrder
import com.iamageo.domain.util.OrderType

data class NottyeStates(
    val notes: List<Nottye> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
    val isDarkTheme: Boolean = true
)
