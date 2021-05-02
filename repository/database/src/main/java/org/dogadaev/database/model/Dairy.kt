package org.dogadaev.database.model

data class DairyDB(
    val id: Int,
    val title: String,
    val description: String,
    val creationDate: String,
    val entries: List<Entry>
) {
    data class Entry(
        val timestamp: String,
        val content: String
    )
}

