package org.dogadaev.navigation

import android.app.Application
import androidx.navigation.NavController
import org.dogadaev.navigation.extensions.onNavHostReady
import javax.inject.Inject

class NavigatorImpl @Inject constructor(
    val application: Application
): Navigator {

    private val navigationController: NavController by onNavHostReady()

    override fun navigate(screen: NavigationGraphScreen) {
        navigationController.navigate(
            when (screen) {
                is NavigationGraphScreen.Home -> NavGraphDirections.actionHome()
                is NavigationGraphScreen.DiaryCreationForm -> NavGraphDirections.actionDiaryCreationForm()
                is NavigationGraphScreen.Diary -> NavGraphDirections.actionDiary(screen.diaryId)
            }
        )
    }

    override fun navigateBack() {
        navigationController.popBackStack()
    }
}