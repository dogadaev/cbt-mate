package org.dogadaev.entity

data class Diary(
    val id: String,
    val title: String,
    val description: String,
    val creationDate: Long,
    val entries: List<Entry> = emptyList(),
) {
    sealed class Entry {
        abstract val timestamp: Long

        /*
            * Ситуация(событие или размышление)
            * Автоматические мысли
            * Эмоции
            * Поведение
        */
        class Worry(
            override val timestamp: Long,
            val situationDescription: String,
            val automaticThought: AutomaticThought,
            val emotions: List<Emotion>,
            val behaviourDescription: String,
        ) : Entry()

        // TODO: Maybe add a possibility to attach documents/media in the future
        class Any(
            override val timestamp: Long,
            val text: String,
        ) : Entry()
    }

    sealed class Emotion {
        abstract val intensity: Int

        data class Standard(
            val emotion: StandardEmotion,
            override val intensity: Int,
        ) : Emotion()

        data class Custom(
            val name: String,
            override val intensity: Int,
        ) : Emotion()

        enum class StandardEmotion {
            Fear,
            Anger,
            Anxiety,
            Sadness,
            Disgust,
            Jealousy,
            Loneliness,
        }
    }

    data class AutomaticThought(
        val thought: String,
        val analysis: String,
    )
}