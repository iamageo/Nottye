package com.iamageo.nottye.ui.screens.home

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.iamageo.domain.util.NoteOrder
import com.iamageo.domain.util.OrderType
import com.iamageo.nottye.R
import com.iamageo.nottye.Screens
import com.iamageo.nottye.ui.screens.home.components.OrderSection

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NottyeHomeScreen(
    navController: NavController,
    viewModel: NottyeViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.NottyeAddEditScreen.route)
                },
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
                    TopBarItem(icon = R.drawable.ic_sort) {
                        viewModel.onEvent(NottyeEvents.ToggleOrderSection)
                    }
                    TopBarItem(icon = R.drawable.ic_settings) {}
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
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    noteOrder = NoteOrder.Date(OrderType.Ascending),
                    onOrderChange = {
                        viewModel.onEvent(NottyeEvents.Order(it))
                    }
                )
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.notes) { nottye ->
                    Text(text = nottye.title, color = Color.Blue)
                }
            }

        }
    }
}

@Composable
fun TopBarItem(icon: Int, onClick: () -> Unit) {
    IconButton(
        onClick = {
            onClick.invoke()
        },
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Sort"
        )
    }
}