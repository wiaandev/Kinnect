package com.example.kinnect.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@ExperimentalMaterial3Api
@Composable
fun Badge(
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Blue,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable (RowScope.() -> Unit)? = null,
){}

