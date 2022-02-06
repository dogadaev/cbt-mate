package org.dogadaev.interactor.usecase

import kotlinx.coroutines.flow.Flow
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {

    val diaries = diaryRepository.diaries

    suspend fun removeDairy(diary: Diary) = diaryRepository.removeDairy(diary)
}