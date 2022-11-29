package com.arifahmadalfian.rawgapp.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFF102A43)
val PrimaryVariant = Color(0xFF0009B3)
val Secondary = Color(0xFF03DAC5)
val SecondaryVariant = Color(0xFF0D2236)

val LightGray = Color(0xFFD8D8D8)
val StarColor = Color(0xFFFFC94D)

val Colors.topAppBarContentColor
    @Composable
    get() = if (isLight) Color.White else LightGray

val Colors.topAppBarBackgroundColor
    @Composable
    get() = if (isLight) Primary else Color.Black