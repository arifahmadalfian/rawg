package com.arifahmadalfian.rawgapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = SecondaryVariant,
    primaryVariant = PrimaryVariant,
    secondary = Secondary
)

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    secondary = Secondary

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun RawgAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }


    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = SecondaryVariant
    )

    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}