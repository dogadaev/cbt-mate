package org.dogadaev.interactor.usecase

import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val diaryRepository: DiaryRepository
) {

    val diaries = diaryRepository.diariesResource.data

    suspend fun removeDairy(diary: Diary) = diaryRepository.removeDairy(diary)
}