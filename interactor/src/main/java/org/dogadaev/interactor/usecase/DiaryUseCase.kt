package org.dogadaev.interactor.usecase

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import java.lang.System.currentTimeMillis
import javax.inject.Inject

class DiaryUseCase @AssistedInject constructor(
    @Assisted private val diaryId: String,
    private val repository: DiaryRepository
) {

    suspend fun getDiary() = repository.getDiaryFlow(diaryId)

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