package com.iamageo.nottye.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.iamageo.nottye.R
import com.iamageo.nottye.Screens
import com.iamageo.nottye.ui.screens.home.components.NottyeItem
import com.iamageo.nottye.ui.screens.home.components.OrderSection
import kotlinx.coroutines.launch

@Composable
fun NottyeHomeScreen(
    navController: NavController,
    viewModel: NottyeViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screens.NottyeAddEditScreen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    tint = MaterialTheme.colors.secondary,
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
                }
            }
        },
        scaffoldState = scaffoldState
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
                    noteOrder = state.noteOrder,
                    onOrderChange = {
                        viewModel.onEvent(NottyeEvents.Order(it))
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.notes) { nottye ->
                    NottyeItem(
                        nottye = nottye,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    Screens.NottyeAddEditScreen.route +
                                            "?noteId=${nottye.id}&noteColor=${nottye.color}"
                                )
                            },
                        onDeleteClick = {
                            viewModel.onEvent(NottyeEvents.DeleteNottye(nottye))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Nottye deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(NottyeEvents.RestoreNottye)
                                }
                            }
                        }
                    )
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

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun MyHomeScreen() {
    val nav = rememberNavController()
    NottyeHomeScreen(navController = nav)
}