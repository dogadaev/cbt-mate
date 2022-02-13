package org.dogadaev.home.compose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.dogadaev.home.compose.HomeScreen
import org.dogadaev.navigation.compose.NavDestination

fun NavGraphBuilder.addHomeScreen(
    navigator: NavController,
) {
    composable(
        route = NavDestination.Home.route
    ) {
        HomeScreen(
            openDiary = { diaryId ->
                navigator.navigate(
                    NavDestination.Diary.buildDestination(diaryId)
                )
            }
        )
    }
}