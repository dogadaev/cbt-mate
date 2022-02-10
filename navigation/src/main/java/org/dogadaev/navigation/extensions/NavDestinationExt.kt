package org.dogadaev.navigation.extensions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.dogadaev.navigation.compose.NavEntry

typealias NavDestinations = Set<NavEntry>

fun NavGraphBuilder.composableNavEntry(
    destination: NavEntry,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
) {
    with(destination) {
        composable(name, arguments, deepLinks) { ScreenComposable() }
    }
}
