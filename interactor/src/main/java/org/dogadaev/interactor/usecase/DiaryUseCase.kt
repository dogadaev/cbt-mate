package org.dogadaev.interactor.usecase

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import org.dogadaev.entity.Diary
import org.dogadaev.interactor.repository.DiaryRepository
import java.lang.System.currentTimeMillis
import kotlin.random.Random

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
            situationDescription = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).".dropLast((0..400).random()),
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