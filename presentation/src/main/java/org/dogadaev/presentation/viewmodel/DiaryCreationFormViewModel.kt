package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.DiaryCreationUseCase
import java.util.*

class DiaryCreationFormViewModel(
    private val useCase: DiaryCreationUseCase
): ViewModel() {

    val diarySavedResult = MutableLiveData<Boolean>()

    fun createDiary(model: DiaryCreationModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val id = UUID.randomUUID().toString()

            val testDairy = Diary(
                id,
                model.name,
                model.description,
                System.currentTimeMillis(),
                emptyList()
            )
            useCase.saveDairy(testDairy)
            diarySavedResult.postValue(true)
        }
    }

    data class DiaryCreationModel(
        val name: String,
        val description: String
    )
}