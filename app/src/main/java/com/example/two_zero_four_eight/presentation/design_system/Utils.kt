package com.example.two_zero_four_eight.presentation.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.two_zero_four_eight.domain.use_cases.DEFAULT_VALUE

@Composable
fun Int.toDp(): Dp {
    val density = LocalDensity.current
    return with(density) { this@toDp.toDp() }
}

@Composable
fun Dp.toPx(): Float {
    val density = LocalDensity.current
    return value * density.density
}

fun TextMeasurer.getMeasureResult(text: String, style: TextStyle): TextLayoutResult {
    return measure(
        text = text,
        style = style,
        maxLines = 1
    )
}

fun TextMeasurer.getCellMeasureResult(cell: Int, style: TextStyle): TextLayoutResult {
    return measure(
        text = if (cell == DEFAULT_VALUE) "" else cell.toString(),
        style = style,
        maxLines = 1
    )
}

@Composable
fun TextLayoutResult.heightDp(): Dp {
    return size.height.toDp()
}