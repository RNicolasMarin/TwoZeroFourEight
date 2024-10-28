package com.example.two_zero_four_eight.presentation_old.ui.game.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.two_zero_four_eight.presentation_old.ui.game.SingleGameState
import com.example.two_zero_four_eight.presentation_old.ui.game.components.BoardGameOld
import com.example.two_zero_four_eight.presentation_old.design_system.Green7
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld
import com.example.two_zero_four_eight.presentation_old.ui.game.components.GameScreenBottomButtons
import com.example.two_zero_four_eight.presentation_old.ui.game.components.GameScreenLeft
import com.example.two_zero_four_eight.presentation_old.design_system.movements.DragGesturesDirectionDetector
import com.example.two_zero_four_eight.presentation_old.design_system.movements.MovementDirection
import com.example.two_zero_four_eight.presentation_old.ui.game.GameAction
import com.example.two_zero_four_eight.presentation_old.ui.game.GameAction.*

@Composable
fun GameScreenLandscape(
    currentState: SingleGameState,
    currentDirection: MovementDirection,
    showAllSections: Boolean,
    isLoading: Boolean,
    onAction: (GameAction) -> Unit
) {
    val uiSectionSizes = getUiSectionSizesLandscape(LocalConfiguration.current, MaterialTheme.dimensOld.outerPadding, showAllSections)

    Box {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Green7)
        ) {
            if (showAllSections) {
                GameScreenLeft(
                    uiState = currentState,
                    uiSectionSizes = uiSectionSizes,
                    isLoading = isLoading,
                    modifier = Modifier
                        .width(uiSectionSizes.singlePartWidth)
                )
            }
            BoardGameOld(
                tableData = currentState.board,
                currentDirection = currentDirection,
                boardGameSize = uiSectionSizes.boardGameSize,
                isLoading = isLoading,
                modifier = Modifier
                    .width(uiSectionSizes.singlePartWidth)
                    .height(uiSectionSizes.boardGameHeight)
            )
        }
        DragGesturesDirectionDetector(
            modifier = Modifier.fillMaxSize(),
            onDirectionDetected = {
                onAction(OnMoveNumbers(it))
            }
        ) {
            if (showAllSections) {
                GameScreenBottomButtons(
                    topHeight = uiSectionSizes.topHeight,
                    boardGameHeight = 0.dp,
                    singlePartHeight = uiSectionSizes.singlePartHeight,
                    modifier = Modifier.width(uiSectionSizes.singlePartWidth),
                    onAction = onAction
                )
            }
        }
    }
}

fun getUiSectionSizesLandscape(
    configuration: Configuration,
    outerPadding: Dp,
    showAllSections: Boolean
): UiSectionSizesLandscape {
    val totalHeight = configuration.screenHeightDp.dp
    val totalWidth = configuration.screenWidthDp.dp

    val singlePartHeight = totalHeight.times(0.2f)
    val topHeight = totalHeight.times(0.6f)
    val bottomHeight = totalHeight.times(0.4f)
    val boardGameHeight = totalHeight.times(1f)

    val width = totalWidth.div(if (showAllSections) 2 else 1).minus(outerPadding + outerPadding)
    val boardGameSize = if (width <= boardGameHeight) width else boardGameHeight

    val singlePartWidth = totalWidth.div(if (showAllSections) 2 else 1)

    return UiSectionSizesLandscape(
        singlePartHeight = singlePartHeight,
        topHeight = topHeight,
        boardGameHeight = boardGameHeight,
        boardGameSize = boardGameSize,
        bottomHeight = bottomHeight,
        singlePartWidth = singlePartWidth
    )
}

data class UiSectionSizesLandscape(
    val singlePartHeight: Dp,
    val topHeight: Dp,
    val boardGameHeight: Dp,
    val boardGameSize: Dp,
    val bottomHeight: Dp,
    val singlePartWidth: Dp
)