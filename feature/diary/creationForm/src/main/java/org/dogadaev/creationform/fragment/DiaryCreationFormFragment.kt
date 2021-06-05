package org.dogadaev.creationform.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.dogadaev.creationform.R
import org.dogadaev.creationform.databinding.FragmentDiaryCreationFormBinding
import org.dogadaev.creationform.presentation.DiaryCreationFormViewInteractor
import org.dogadaev.navigation.Navigator
import org.dogadaev.presentation.viewmodel.DiaryCreationFormViewModel
import org.dogadaev.ui.extensions.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiaryCreationFormFragment(
    private val navigator: Navigator,
) : Fragment(R.layout.fragment_diary_creation_form) {

    private val viewModel: DiaryCreationFormViewModel by viewModel()
    private val binding by viewBinding(FragmentDiaryCreationFormBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DiaryCreationFormViewInteractor(this, binding, viewModel, navigator)
    }
}