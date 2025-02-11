package com.iamageo.nottye.ui.screens.home

/*
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.core.app.ApplicationProvider
import com.iamageo.nottye.NottyeMain
import com.iamageo.nottye.Screens
import com.iamageo.nottye.di.AppModule
import com.iamageo.nottye.ui.theme.NottyeTheme
import com.iamageo.nottye.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(AppModule::class)
class NottyeHomeScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<NottyeMain>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            val navController = rememberNavController()

            NottyeTheme() {
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

    @Test
    fun testToggleOrderSection_isVisible(){
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()
        composeRule.onNodeWithContentDescription("Sort").performClick()
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }


}

 */