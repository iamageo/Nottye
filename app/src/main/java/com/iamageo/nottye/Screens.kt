package com.iamageo.nottye

sealed class Screens(val route: String) {
    object NottyeHomeScreen : Screens("nottye_home_screen")
    object NottyeAddEditScreen : Screens("nottye_addedit_screen")
}