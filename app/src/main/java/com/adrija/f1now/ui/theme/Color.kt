package com.adrija.f1now.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

val RacingRed = Color(0xFFEA2C2C)
val AsphaltDark = Color(0xFF121212)
val CarbonGray = Color(0xFF1F1F1F)
val NeonAccent = Color(0xFF00FFD1)

val DarkColorScheme = darkColorScheme(
    primary = RacingRed,
    secondary = NeonAccent,
    background = AsphaltDark,
    surface = CarbonGray,
    onPrimary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

