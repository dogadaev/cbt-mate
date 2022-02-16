package org.dogadaev.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class DiaryWithEntries(
    @Embedded val diary: DiaryDB,
    @Relation(
        parentColumn = "id",
        entityColumn = "diaryId"
    ) val diaryEntries: List<DiaryDB.Entry>,
)

@Entity(tableName = "diaries")
data class DiaryDB(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val creationTimestamp: Long,
    val lastModifiedTimestamp: Long,
) {

    @Entity(tableName = "diary_entries")
    data class Entry(
        @PrimaryKey(autoGenerate = true) val entryId: Long = 0,
        val diaryId: String,
        val timestamp: Long,
        val situationDescription: String,
        @Embedded val automaticThought: AutomaticThought,
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
