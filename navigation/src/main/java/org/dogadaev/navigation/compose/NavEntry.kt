package org.dogadaev.navigation.compose

import androidx.compose.runtime.Composable

sealed class NavEntry(
    val name: String
) {

    @Composable
    abstract fun ScreenComposable()

    abstract class HomeDestination: NavEntry("home")
    abstract class DiaryDestination: NavEntry("diary")
}