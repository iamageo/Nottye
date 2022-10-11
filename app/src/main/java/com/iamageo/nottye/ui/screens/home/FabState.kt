package com.iamageo.nottye.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

sealed class FabState {
    object Collapsed : FabState()
    object Expand : FabState()

    fun toggleValue() = if (isExpanded()) {
        Collapsed
    } else {
        Expand
    }

    fun isExpanded() = this == Expand
}

@Composable
fun rememberFabState() = remember { mutableStateOf<FabState>(FabState.Collapsed) }