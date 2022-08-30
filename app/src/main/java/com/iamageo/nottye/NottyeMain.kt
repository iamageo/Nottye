package com.iamageo.nottye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import com.iamageo.nottye.ui.theme.NottyeTheme

class NottyeMain : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NottyeTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { },
                            backgroundColor = Color.Black
                        ) {
                            Icon(imageVector = Icons.Default.Add, tint = Color.White, contentDescription = "Add")
                        }
                    }
                ) {

                }
            }
        }
    }
}