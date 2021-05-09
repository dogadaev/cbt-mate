package org.dogadaev.entity

data class Diary(
    val id: String,
    val title: String,
    val description: String,
    val creationDate: Long,
    val entries: List<Entry> = emptyList()
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
            val situation: String,
            val automaticThought: AutomaticThought,
            val emotions: List<Emotion>,
            val behaviour: String
        ) : Entry()

        // TODO: Maybe add a possibility to attach documents/media in the future
        class Any(
            override val timestamp: Long,
            val text: String
        ) : Entry()
    }

    sealed class Emotion {
        abstract val intensity: Int

        class Anxiety(override val intensity: Int) : Emotion()
        class Anger(override val intensity: Int) : Emotion()
        class Sadness(override val intensity: Int) : Emotion()
        class Fear(override val intensity: Int) : Emotion()
        class Jealousy(override val intensity: Int) : Emotion()
        class Loneliness(override val intensity: Int) : Emotion()
        class Disgust(override val intensity: Int) : Emotion()
        class Custom(override val intensity: Int) : Emotion()
    }

    data class AutomaticThought(
        val thought: String,
        val analysis: String,
    )
}