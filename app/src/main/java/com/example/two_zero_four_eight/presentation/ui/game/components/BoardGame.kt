package com.example.two_zero_four_eight.presentation.ui.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.two_zero_four_eight.domain.models.fiveXFive
import com.example.two_zero_four_eight.domain.models.threeXThree
import com.example.two_zero_four_eight.domain.use_cases.DEFAULT_VALUE
import com.example.two_zero_four_eight.presentation.design_system.Dimens
import com.example.two_zero_four_eight.presentation.design_system.TwoZeroFourEightTheme
import com.example.two_zero_four_eight.presentation.design_system.dimens
import com.example.two_zero_four_eight.presentation.design_system.typographies
import com.example.two_zero_four_eight.presentation_old.design_system.Black
import com.example.two_zero_four_eight.presentation_old.design_system.Grey2
import com.example.two_zero_four_eight.presentation_old.design_system.shimmerEffect
import com.example.two_zero_four_eight.presentation_old.ui.game.components.getCellData
import kotlin.math.sqrt

@Composable
fun BoardGame(
    data: List<Int> = emptyList(),
    isLoading: Boolean = false,
    dimens: Dimens = MaterialTheme.dimens,
    modifier: Modifier = Modifier
) {
    val innerBoardPadding = dimens.innerBoardPadding
    val cornerRadius = dimens.cornerRadius

    BoxWithConstraints {
        val minSize = min(maxWidth, maxHeight)

        Box(
            modifier = modifier
                .size(minSize)
        ) {
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .size(minSize)
                        .padding(innerBoardPadding)
                        .shimmerEffect(
                            RoundedCornerShape(cornerRadius)
                        )
                )
            } else {
                BoardGameCanvas(
                    boardSize = minSize,
                    data = data,
                    innerBoardPadding = innerBoardPadding,
                    cornerRadius = cornerRadius
                )
            }
        }
    }
}

@Composable
fun BoardGameCanvas(
    boardSize: Dp,
    data: List<Int>,
    innerBoardPadding: Dp,
    cornerRadius: Dp,
    textStyle: TextStyle = MaterialTheme.typographies.text24Bold,
) {
    val measurer = rememberTextMeasurer()

    Canvas(
        modifier = Modifier
            .size(boardSize)
    ) {

        val cellSideAmounts = sqrt(data.size.toDouble()).toInt()
        val totalSizePx = size.height
        val paddingPx = innerBoardPadding.toPx()
        val totalSizeWithoutSpacesPx = totalSizePx - paddingPx * cellSideAmounts - paddingPx
        val cellSizePx = totalSizeWithoutSpacesPx / cellSideAmounts

        val radiusPx = cornerRadius.toPx()
        drawRoundRect(
            topLeft = Offset(0f, 0f),
            color = Grey2,
            cornerRadius = CornerRadius(radiusPx, radiusPx)
        )

        var y = paddingPx
        data.forEachIndexed { index, cell ->
            val position = index % cellSideAmounts
            val x = paddingPx + cellSizePx * position + paddingPx * position

            val cellData = getCellData(cell)

            drawRoundRect(
                topLeft = Offset(x, y),
                size = Size(cellSizePx, cellSizePx),
                color = cellData.backgroundColor,
                cornerRadius = CornerRadius(radiusPx, radiusPx)
            )

            drawRoundRect(
                topLeft = Offset(x, y),
                size = Size(cellSizePx, cellSizePx),
                color = Black,
                cornerRadius = CornerRadius(radiusPx, radiusPx),
                style = Stroke(1.dp.toPx())
            )

            val valueResult = measurer.measure(
                text = if (cell == DEFAULT_VALUE) "" else cell.toString(),
                style = textStyle.copy(
                    color = cellData.textColor,
                    textAlign = TextAlign.Center
                ),
                maxLines = 1
            )
            val textY = y + cellSizePx / 2 - valueResult.size.height / 2
            val textX = x + cellSizePx / 2 - valueResult.size.width / 2
            drawText(
                topLeft = Offset(textX, textY),
                textLayoutResult = valueResult,
            )

            if (position == cellSideAmounts -1) {
                y += paddingPx + cellSizePx
            }
        }
    }
}

@Preview(heightDp = 320, widthDp = 240)
@Composable
private fun LabelTextPreview1() {
    TwoZeroFourEightTheme {
        BoardGame(
            data = fiveXFive.flatten(),
            modifier = Modifier,
        )
    }
}

@Preview(heightDp = 240, widthDp = 320)
@Composable
private fun LabelTextPreview2() {
    TwoZeroFourEightTheme {
        BoardGame(
            data = threeXThree.flatten(),
            modifier = Modifier,
        )
    }
}