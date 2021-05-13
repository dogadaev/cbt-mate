package org.dogadaev.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DiaryDB(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val creationDate: Long,
) {

    @Entity
    data class Entry(
        val timestamp: String,
        val content: String
    )
}

