package com.iamageo.nottye.ui.screens.addedit

import androidx.compose.ui.focus.FocusState

sealed class AddEditNottyeEvents {
    data class EnteredTitle(val value: String) : AddEditNottyeEvents()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNottyeEvents()
    data class EnteredContent(val value: String) : AddEditNottyeEvents()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNottyeEvents()
    data class ChangeColor(val color: Int) : AddEditNottyeEvents()
    object SaveNote : AddEditNottyeEvents()
}