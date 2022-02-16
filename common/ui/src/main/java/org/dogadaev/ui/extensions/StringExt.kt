package org.dogadaev.ui.extensions

import java.util.*

fun String.capitalize() =
   lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }