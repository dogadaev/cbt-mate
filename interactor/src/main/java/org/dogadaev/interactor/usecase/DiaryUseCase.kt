package org.dogadaev.interactor.usecase

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import java.lang.System.currentTimeMillis

class DiaryUseCase @AssistedInject constructor(
    @Assisted private val diaryId: String,
    private val repository: DiaryRepository
) {

    val diary = repository.diaryResource.parametrizedFlow(
        parameter = diaryId
    )

    suspend fun insertEntry() {
        val entry = Diary.Entry(
            diaryId,
            timestamp = currentTimeMillis(),
            situationDescription = "situationDescription",
            automaticThought = Diary.AutomaticThought(
                thought = "thought",
                analysis = "analysis",
            ),
            emotions = listOf(
                Diary.Emotion(
                    Diary.Emotion.StandardEmotion.Anxiety,
                    intensity = 5
                )
            ),
            behaviourDescription = "behaviourDescription"
        )

        repository.saveEntry(entry)
    }
}