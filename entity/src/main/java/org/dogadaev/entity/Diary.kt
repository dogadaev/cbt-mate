package org.dogadaev.entity

data class Diary(
    val id: String,
    val title: String,
    val description: String,
    val creationDate: Long,
    val diaryEntries: List<Entry>,
) {

    data class Entry(
        val diaryId: String,
        val timestamp: Long,
        val situationDescription: String,
        val automaticThought: AutomaticThought,
        val emotions: List<Emotion>,
        val behaviourDescription: String,
    )

    data class Emotion(
        val emotion: StandardEmotion,
        val intensity: Int,
    ) {

        enum class StandardEmotion {
            Fear,
            Anger,
            Anxiety,
            Sadness,
            Disgust,
            Jealousy,
            Loneliness
        }
    }

    data class AutomaticThought(
        val thought: String,
        val analysis: String,
    )
}