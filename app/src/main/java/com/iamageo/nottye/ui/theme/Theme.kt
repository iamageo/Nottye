package com.iamageo.nottye.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.iamageo.nottye.DarkColorPalette
import com.iamageo.nottye.LightColors
import com.iamageo.nottye.NottyeTypography


@Composable
fun NottyeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = NottyeTypography,
        shapes = Shapes,
        content = content
    )
}