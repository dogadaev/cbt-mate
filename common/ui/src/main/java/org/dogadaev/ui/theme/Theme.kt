package org.dogadaev.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightTheme = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    onPrimary = White,
    secondary = Purple500,
    secondaryVariant = Purple700,
    onSecondary = White,
    error = Red800
)

private val DarkTheme = darkColors(
    primary = Purple200,
    primaryVariant = Purple500,
    onPrimary = Black,
    secondary = Purple200,
    onSecondary = Black,
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