package org.dogadaev.ui.extensions

import java.text.SimpleDateFormat
import java.util.*

val Long.formattedDate: String
    get() = SimpleDateFormat("d MMM", Locale.getDefault()).format(
        Date(this)
    )

val Long.formattedTime: String
    get() = SimpleDateFormat("h:mm", Locale.getDefault()).format(
        Date(this)
    )