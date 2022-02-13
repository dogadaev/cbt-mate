package org.dogadaev.navigation.compose

import androidx.compose.runtime.Composable

sealed class NavDestination(
    val route: String
) {
    object Home : NavDestination(route = "home")
    object Diary : NavDestination(route = "diary")
}