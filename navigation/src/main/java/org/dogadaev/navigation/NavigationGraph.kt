package org.dogadaev.navigation

sealed class NavigationGraph {
    object Home: NavigationGraph()
    class Diary(val diaryId: String): NavigationGraph()
}