package org.dogadaev.navigation

import android.app.Application
import androidx.navigation.NavController
import org.dogadaev.navigation.extensions.onNavHostReady

internal class NavigatorImpl(
    val application: Application
): Navigator {

    private val navigationController: NavController by onNavHostReady()

    override fun navigate(screen: NavigationGraph) {
        navigationController.navigate(
            when (screen) {
                NavigationGraph.Home -> NavGraphDirections.actionHome()
                NavigationGraph.Diary -> NavGraphDirections.actionDiary()
            }
        )
    }
}