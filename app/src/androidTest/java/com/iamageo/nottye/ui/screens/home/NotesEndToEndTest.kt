package com.iamageo.nottye.ui.screens.home

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iamageo.nottye.NottyeMain
import com.iamageo.nottye.Screens
import com.iamageo.nottye.di.AppModule
import com.iamageo.nottye.ui.screens.addedit.AddEditNottyeScreen
import com.iamageo.nottye.ui.screens.splash.NottyeSplashScreen
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
class NotesEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<NottyeMain>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            NottyeTheme() {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.NottyeSplashScreen.route
                ) {
                    composable(route = Screens.NottyeSplashScreen.route) {
                        NottyeSplashScreen(navController = navController)
                    }
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

    @Test
    fun saveNewNottye_editAfterwards() {

        //click on add new nottye
        composeRule.onNodeWithContentDescription("Add").performClick()

        //enter textx in title and content fields
        composeRule.onNodeWithTag(TestTags.TITLE_TEXT_FIELD).performTextInput("test-title")
        composeRule.onNodeWithTag(TestTags.CONTENT_TEXT_FIELD).performTextInput("test-content")

        //click on save nottye
        composeRule.onNodeWithContentDescription("Save").performClick()

        // verify if test-title is visible
        composeRule.onNodeWithText("test-title").assertIsDisplayed()

        //click in test title for edit nottye
        composeRule.onNodeWithText("test-title").performClick()

        //verify if title and content contain contents
        composeRule.onNodeWithText(TestTags.TITLE_TEXT_FIELD).assertTextEquals("test-title")
        composeRule.onNodeWithText(TestTags.CONTENT_TEXT_FIELD).assertTextEquals("test-content")

        //change title to test-2
        composeRule.onNodeWithTag(TestTags.TITLE_TEXT_FIELD).performTextInput("test-2")
        //update the title
        composeRule.onNodeWithContentDescription("Save").performClick()

        //verify if title is changed
        composeRule.onNodeWithText(TestTags.TITLE_TEXT_FIELD).assertTextEquals("test-2")

    }

}