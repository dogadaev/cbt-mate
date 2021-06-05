package org.dogadaev.navigation

sealed class NavigationGraphScreen {
    object Home: NavigationGraphScreen()
    object DiaryCreationForm: NavigationGraphScreen()
    class Diary(val diaryId: String): NavigationGraphScreen()
}