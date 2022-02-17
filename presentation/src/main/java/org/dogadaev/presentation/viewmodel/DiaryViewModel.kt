package org.dogadaev.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.usecase.factory.UseCaseFactory
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(
    savedState: SavedStateHandle,
    useCaseFactory: UseCaseFactory,
) : ViewModel() {

    private val useCase = useCaseFactory.createDiaryUseCase(
        diaryId = savedState["diaryId"]!!
    )

    val data = useCase.diary.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        Diary(
            "", "", "", 0, 0, emptyList()
        )
    )

    fun insertTestEntry() {
        viewModelScope.launch {
            useCase.insertEntry()
        }
    }
}