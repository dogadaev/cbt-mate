package org.dogadaev.diary.compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.dogadaev.diary.compose.screen.DiaryScreen
import org.dogadaev.navigation.compose.NavDestination

fun NavGraphBuilder.addDiaryScreen(
    navController: NavController,
) {
    composable(
        route = NavDestination.Diary.route,
        arguments = listOf(navArgument(NavDestination.Diary.argument) { type = NavType.StringType })
    ) {
        DiaryScreen(
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}