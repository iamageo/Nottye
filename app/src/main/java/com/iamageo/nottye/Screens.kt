package com.iamageo.nottye

sealed class Screens(val route: String) {
    object NottyeSplashScreen : Screens("nottye_splash_screen")
    object NottyeHomeScreen : Screens("nottye_home_screen")
    object NottyeAddEditScreen : Screens("nottye_addedit_screen")
}