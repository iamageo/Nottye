package com.iamageo.nottye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iamageo.nottye.ui.screens.addedit.AddEditNottyeScreen
import com.iamageo.nottye.ui.screens.home.NottyeHomeScreen
import com.iamageo.nottye.ui.theme.NottyeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NottyeMain : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NottyeTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.NottyeHomeScreen.route
                    ) {
                        composable(route = Screens.NottyeHomeScreen.route) {
                            NottyeHomeScreen(navController = navController)
                        }
                        composable(
                            route = Screens.NottyeAddEditScreen.route +
                                    "?noteId={noteId}&noteColor={noteColor}", arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNottyeScreen(navController = navController, noteColor = color)
                        }
                    }
                }
            }
        }
    }
}