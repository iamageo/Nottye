package com.iamageo.nottye

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iamageo.nottye.ui.screens.home.NottyeHomeScreen
import com.iamageo.nottye.ui.screens.home.NottyeViewModel
import com.iamageo.nottye.ui.theme.NottyeTheme
import dagger.hilt.EntryPoint
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
                    }
                }
            }
        }
    }
}