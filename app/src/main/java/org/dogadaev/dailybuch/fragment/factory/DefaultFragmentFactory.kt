package org.dogadaev.dailybuch.fragment.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import org.dogadaev.creationform.fragment.DiaryCreationFormFragment
import org.dogadaev.diary.fragment.DiaryFragment
import org.dogadaev.home.fragment.HomeFragment
import org.dogadaev.navigation.Navigator
import org.dogadaev.presentation.viewmodel.factory.AssistedViewModelFactory
import javax.inject.Inject

class DefaultFragmentFactory @Inject constructor(
    private val navigator: Navigator,
    private val assistedViewModelFactory: AssistedViewModelFactory
) : FragmentFactory() {

    override fun instantiate(
        classLoader: ClassLoader,
        className: String
    ): Fragment = when (className) {
        HomeFragment::class.java.name -> HomeFragment(navigator)
        DiaryFragment::class.java.name -> DiaryFragment(navigator, assistedViewModelFactory)
        DiaryCreationFormFragment::class.java.name -> DiaryCreationFormFragment(navigator)
        else -> super.instantiate(classLoader, className)
    }
}