package org.dogadaev.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.dogadaev.navigation.extensions.NavDestinations
import org.dogadaev.navigation.extensions.composableNavEntry


class ComposeNavigation(
    private val destinations: NavDestinations
) {

    @Composable
    fun AppNavGraph() {
        NavHost(
            rememberNavController(),
            destinations.first().name
        ) {
            destinations.forEach(::composableNavEntry)
        }
    }
}