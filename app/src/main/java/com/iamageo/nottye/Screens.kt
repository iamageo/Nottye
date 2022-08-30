package com.iamageo.nottye

sealed class Screens(val route: String) {
    object NottyeHomeScreen : Screens("nottye_home_screen")
}