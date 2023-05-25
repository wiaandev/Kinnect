package com.example.kinnect.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val K_Orange = Color(0xFFF96042)
val K_OrangeDark = Color(0xFFED3B20)
val K_OrangeLight = Color(0xFFFA7E63)
val K_OrangeLighter = Color(0xFFF8E0DE)

val K_Charcoal = Color(0xFF303841)
val K_CharcoalLight = Color(0xFF434D59)

val K_White = Color(0xFFF7F8FD)
val K_WhiteDark = Color(0xFFE5E6EB)

val gradient = Brush.horizontalGradient(
    0.0f to K_Orange,
    1.0f to K_OrangeLight,
    startX = -1000.0f,
    endX = 1000.0f
)