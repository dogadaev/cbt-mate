package org.dogadaev.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.dogadaev.ui.R

private val CormorantGaramondFontFamily = FontFamily(
    listOf(
        Font(R.font.cormorant_garamond_regular),
        Font(R.font.cormorant_garamond_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.cormorant_garamond_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.cormorant_garamond_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.cormorant_garamond_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.cormorant_garamond_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.cormorant_garamond_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.cormorant_garamond_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.cormorant_garamond_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.cormorant_garamond_bold_italic, FontWeight.Bold, FontStyle.Italic),
    )
)

private val RalewayFontFamily = FontFamily(
    listOf(
        Font(R.font.raleway_regular),
        Font(R.font.raleway_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.raleway_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
        Font(R.font.raleway_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
        Font(R.font.raleway_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.raleway_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.raleway_thin, FontWeight.Thin, FontStyle.Normal),
        Font(R.font.raleway_thin_italic, FontWeight.Thin, FontStyle.Italic),
        Font(R.font.raleway_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.raleway_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.raleway_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.raleway_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(R.font.raleway_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.raleway_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.raleway_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(R.font.raleway_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(R.font.raleway_black, FontWeight.Black, FontStyle.Normal),
        Font(R.font.raleway_black_italic, FontWeight.Black, FontStyle.Italic),
    )
)

val Typography = Typography(
    defaultFontFamily = RalewayFontFamily,
)
