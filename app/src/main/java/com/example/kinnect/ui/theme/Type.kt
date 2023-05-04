package com.example.kinnect.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kinnect.R

val epilogue = FontFamily(
        Font(R.font.epilogue_regular),
        Font(R.font.epilogue_bold, weight = FontWeight.Bold),
)

val epilogueHeading = TextStyle(
    fontFamily = epilogue,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
)

val epilogueH2 = TextStyle(
    fontFamily = epilogue,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
)


val epilogueH3 = TextStyle(
    fontFamily = epilogue,
    fontWeight = FontWeight.Normal,
    fontSize = 17.sp,
)


val epilogueBody = TextStyle(
    fontFamily = epilogue,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = epilogue,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)