package com.brave.shoppy.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
    val extraXLarge: Dp = 80.dp,
)

data class CustomSize(
    val cartItemReviewHeight: Dp = 140.dp,
    val cartItemReviewButtonSize: Dp = 28.dp,
    val cartItemReviewIconSize: Dp = 18.dp,
    val mapCardIconSize: Dp = 64.dp,
    val mapCardItemHeight: Dp = 100.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }
val LocalSize = compositionLocalOf { CustomSize() }


val MaterialTheme.spacing: Spacing
    @Composable @ReadOnlyComposable get() = LocalSpacing.current

val MaterialTheme.size: CustomSize
    @Composable @ReadOnlyComposable get() = LocalSize.current
