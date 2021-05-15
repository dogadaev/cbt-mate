package org.dogadaev.navigation

sealed class NavigationGraph {
    object Home: NavigationGraph()
    object Diary: NavigationGraph()
}