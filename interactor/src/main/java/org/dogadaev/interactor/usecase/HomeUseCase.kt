package org.dogadaev.interactor.usecase

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository

class HomeUseCase(
    private val diaryRepository: DiaryRepository
) {

    fun getDairiesFlow(): Flow<List<Diary>> = diaryRepository.getDairiesFlow()
    fun saveDairy(diary: Diary) = diaryRepository.saveDairy(diary)
    fun removeDairy(diary: Diary) = diaryRepository.removeDairy(diary)
}