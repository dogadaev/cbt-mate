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
                is NavigationGraph.Home -> NavGraphDirections.actionHome()
                is NavigationGraph.Diary -> NavGraphDirections.actionDiary(screen.diaryId)
            }
        )
    }
}