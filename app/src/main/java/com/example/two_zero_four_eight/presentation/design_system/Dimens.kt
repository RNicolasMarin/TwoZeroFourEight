package com.example.two_zero_four_eight.presentation.design_system

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val screenPadding: Dp = 8.dp,
    val cornerRadius: Dp = 5.dp,
    val borderStroke: Dp = 1.dp,
    val innerHorizontalPadding: Dp = 10.dp,
    val iconButtonSize: Dp = 45.dp,
)

val dimens320x480 = Dimens(
    screenPadding = 8.dp,
    cornerRadius = 5.dp,
    borderStroke = 1.dp,
    innerHorizontalPadding = 10.dp,
    iconButtonSize = 45.dp,
)
