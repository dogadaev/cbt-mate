package org.dogadaev.ui.extensions

import org.dogadaev.entity.Diary
import java.text.SimpleDateFormat
import java.util.*

val Diary.lastModifiedDate: String
    get() = SimpleDateFormat("d MMM", Locale.getDefault()).format(
        Date(lastModifiedTimestamp)
    )

val Diary.lastModifiedTime: String
    get() = SimpleDateFormat("h:mm", Locale.getDefault()).format(
        Date(lastModifiedTimestamp)
    )