package org.dogadaev.creationform.presentation

import org.dogadaev.creationform.databinding.FragmentDiaryCreationFormBinding
import org.dogadaev.creationform.fragment.DiaryCreationFormFragment
import org.dogadaev.navigation.NavigationGraphScreen
import org.dogadaev.navigation.Navigator
import org.dogadaev.presentation.viewmodel.DiaryCreationFormViewModel

class DiaryCreationFormViewInteractor(
    private val fragment: DiaryCreationFormFragment,
    private val binding: FragmentDiaryCreationFormBinding,
    private val viewModel: DiaryCreationFormViewModel,
    private val navigator: Navigator
) {

    init {
        setupToolbar()
        setupListeners()
        observerSaveResult()
    }

    private fun setupToolbar() {
        binding.title.text = "New Diary"
    }

    private fun setupListeners() {
        binding.submitButton.setOnClickListener {
            viewModel.createDiary(
                binding.buildFormModel()
            )
        }
    }

    private fun observerSaveResult() {
        viewModel.diarySavedResult.observe(fragment.viewLifecycleOwner) { success ->
            if(success) navigator.navigateBack()
        }
    }

    private fun FragmentDiaryCreationFormBinding.buildFormModel() =
        DiaryCreationFormViewModel.DiaryCreationModel(
            name.text.toString(),
            description.text.toString()
        )
}