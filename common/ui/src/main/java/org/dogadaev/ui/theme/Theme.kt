package org.dogadaev.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightTheme = lightColors(
    primary = Black,
    primaryVariant = Black,
    onPrimary = White,
    secondary = Grey400,
    secondaryVariant = Grey400,
    onSecondary = White,
    surface = White,
    background = White,
    error = Red800
)

private val DarkTheme = darkColors(
    primary = White,
    primaryVariant = White,
    onPrimary = Grey600,
    secondary = Grey100,
    secondaryVariant = Grey100,
    onSecondary = Black,
    surface = Black,
    background = Grey600,
    error = Red800
)

@Composable
fun CbtMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val theme = if (darkTheme) DarkTheme else LightTheme

    MaterialTheme(
        colors = theme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}