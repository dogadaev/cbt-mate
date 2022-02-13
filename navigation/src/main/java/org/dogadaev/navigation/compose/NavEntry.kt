package org.dogadaev.navigation.compose

sealed class NavDestination(
    val name: String,
    val argument: String = ""
) {
    val route = with (argument) {
        if(isNotEmpty()) "$name/{$argument}"
        else name
    }
    object Home : NavDestination(name = "home")
    object Diary : NavDestination(name = "diary", argument = "diaryId") {
        fun buildDestination(diaryId: String) = "$name/$diaryId"
    }
}