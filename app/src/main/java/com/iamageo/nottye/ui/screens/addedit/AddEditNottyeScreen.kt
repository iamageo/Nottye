package com.iamageo.nottye.ui.screens.addedit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.iamageo.nottye.R
import com.iamageo.nottye.Utils.Companion.NottyeColors
import com.iamageo.nottye.ui.screens.home.TopBarItem

@Composable
fun AddEditNottyeScreen(
    navController: NavController,
    addEditNottyeViewModel: AddEditNottyeViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TopBarItem(icon = R.drawable.ic_back) {
                    navController.popBackStack()
                }
            }
        }

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NottyeColors.forEach { color ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color = color)
                            .border(
                                width = 3.dp,
                                color = Color.Black,
                                shape = CircleShape
                            )
                            .clickable {}
                    )
                }
            }
        }
    }
}