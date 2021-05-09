package org.dogadaev.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DairyDB(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val creationDate: String,
) {

    @Entity
    data class Entry(
        val timestamp: String,
        val content: String
    )
}

