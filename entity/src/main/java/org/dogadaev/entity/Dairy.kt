package org.dogadaev.entity

data class Dairy(
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
