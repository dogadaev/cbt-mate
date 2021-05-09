package org.dogadaev.entity

data class Dairy(
    val id: String,
    val title: String,
    val description: String,
    val creationDate: String,
) {
    data class Entry(
        val timestamp: String,
        val content: String
    )
}
