package com.iamageo.nottye.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iamageo.nottye.R

@Composable
fun NottyeHomeScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = Color.White,
                    contentDescription = "Add"
                )
            }
        },
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 2.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Nottye",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Row() {
                        TopBarItem(icon = R.drawable.ic_sort) {}
                        TopBarItem(icon = R.drawable.ic_settings) {}
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
        }
    }
}

@Composable
private fun TopBarItem(icon: Int, onClick: () -> Unit) {
    IconButton(
        onClick = {
            onClick()
        },
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Sort"
        )
    }
}