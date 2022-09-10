package com.iamageo.nottye.ui.screens.addedit

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.iamageo.nottye.R
import com.iamageo.nottye.Screens
import com.iamageo.nottye.Utils.Companion.NottyeColors
import com.iamageo.nottye.ui.screens.addedit.components.NottyeEditText
import com.iamageo.nottye.ui.screens.home.TopBarItem
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddEditNottyeScreen(
    navController: NavController,
    addEditNottyeViewModel: AddEditNottyeViewModel = viewModel(),
    noteColor: Int
) {
    val titleState = addEditNottyeViewModel.noteTitle.value
    val contentState = addEditNottyeViewModel.noteContent.value

    val scaffoldState = rememberScaffoldState()

    val scope = rememberCoroutineScope()

    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if (noteColor != -1) noteColor else addEditNottyeViewModel.noteColor.value)
        )
    }

    LaunchedEffect(key1 = true) {
        addEditNottyeViewModel.eventFlow.collectLatest { event ->
            when(event) {
                is AddEditNottyeViewModel.UiEvents.ShowSnackbar -> {
                }
                is AddEditNottyeViewModel.UiEvents.SaveNottye -> {
                    navController.navigateUp()
                }
            }
        }
    }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    addEditNottyeViewModel.onEvent(AddEditNottyeEvents.SaveNote)
                },
                backgroundColor = Color.Black
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    tint = Color.White,
                    contentDescription = "Save nottye"
                )
            }
        },
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TopBarItem(icon = R.drawable.ic_back) {
                    navController.popBackStack()
                }
            }
        },
        scaffoldState = scaffoldState

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(noteBackgroundAnimatable.value)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NottyeColors.forEach { color ->
                    val colorInt = color.toArgb()
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color = color)
                            .border(
                                width = 3.dp,
                                color = if (addEditNottyeViewModel.noteColor.value == colorInt) {
                                    Color.Black
                                } else Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable {
                                scope.launch {
                                    noteBackgroundAnimatable.animateTo(
                                        targetValue = Color(colorInt),
                                        animationSpec = tween(
                                            durationMillis = 500
                                        )
                                    )
                                }
                                addEditNottyeViewModel.onEvent(
                                    AddEditNottyeEvents.ChangeColor(
                                        colorInt
                                    )
                                )
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            NottyeEditText(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange = {
                    addEditNottyeViewModel.onEvent(AddEditNottyeEvents.EnteredTitle(it))
                },
                onFocusChange = {
                    addEditNottyeViewModel.onEvent(AddEditNottyeEvents.ChangeTitleFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5,
            )
            Spacer(modifier = Modifier.height(16.dp))
            NottyeEditText(
                text = contentState.text,
                hint = contentState.hint,
                onValueChange = {
                    addEditNottyeViewModel.onEvent(AddEditNottyeEvents.EnteredContent(it))
                },
                onFocusChange = {
                    addEditNottyeViewModel.onEvent(AddEditNottyeEvents.ChangeContentFocus(it))
                },
                isHintVisible = contentState.isHintVisible,
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxHeight(),
            )
        }
    }
}