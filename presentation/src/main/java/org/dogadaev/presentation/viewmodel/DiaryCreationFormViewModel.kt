package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.DiaryCreationUseCase
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DiaryCreationFormViewModel @Inject constructor(
    private val useCase: DiaryCreationUseCase
) : ViewModel() {

    val diarySavedResult = MutableLiveData<Boolean>()

    fun createDiary(model: DiaryCreationModel) {
        viewModelScope.launch {
            val id = UUID.randomUUID().toString()

            val testDairy = Diary(
                id,
                model.name,
                model.description,
                System.currentTimeMillis(),
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