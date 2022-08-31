package com.iamageo.nottye.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iamageo.domain.util.NoteOrder
import com.iamageo.domain.util.OrderType
import com.iamageo.nottye.R
import com.iamageo.nottye.ui.screens.components.OrderSection

@OptIn(ExperimentalAnimationApi::class)
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
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    noteOrder = NoteOrder.Date(OrderType.Ascending),
                    onOrderChange = {
                        //viewModel.onEvent(NotesEvent.Order(it))
                    }
                )
            }
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