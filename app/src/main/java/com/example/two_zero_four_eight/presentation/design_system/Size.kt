package com.example.two_zero_four_eight.presentation.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.unit.Dp

data class Size(
    val dp: Dp,
    val px: Int
) {
    operator fun plus(other: Size): Size {
        return Size(
            this.dp + other.dp,
            this.px + other.px,
        )
    }
}

@Composable
fun Int.toSize() : Size {
    return Size(
        px = this,
        dp = this.toDp()
    )
}

@Composable
fun Dp.toSize() : Size {
    return Size(
        px = this.toPx().toInt(),
        dp = this
    )
}

@Composable
fun TextLayoutResult.heightSize(): Size {
    return Size(
        px = size.height,
        dp = size.height.toDp()
    )
}
