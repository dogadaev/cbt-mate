package org.dogadaev.navigation

interface Navigator {
    fun navigate(screen: NavigationGraphScreen)
    fun navigateBack()
}