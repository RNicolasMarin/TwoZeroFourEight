package com.example.two_zero_four_eight.presentation_old.ui.game.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.two_zero_four_eight.presentation_old.ui.game.SingleGameState
import com.example.two_zero_four_eight.presentation_old.ui.game.components.BoardGame
import com.example.two_zero_four_eight.presentation_old.design_system.Green7
import com.example.two_zero_four_eight.presentation_old.design_system.dimens
import com.example.two_zero_four_eight.presentation_old.ui.game.components.GameScreenBottomButtons
import com.example.two_zero_four_eight.presentation_old.ui.game.components.GameScreenTop
import com.example.two_zero_four_eight.presentation_old.design_system.movements.DragGesturesDirectionDetector
import com.example.two_zero_four_eight.presentation_old.design_system.movements.MovementDirection
import com.example.two_zero_four_eight.presentation_old.ui.game.GameAction
import com.example.two_zero_four_eight.presentation_old.ui.game.GameAction.*

@Composable
fun GameScreenPortrait(
    currentState: SingleGameState,
    currentDirection: MovementDirection,
    showAllSections: Boolean,
    isLoading: Boolean,
    onAction: (GameAction) -> Unit
) {
    val uiSectionSizes = getUiSectionSizesPortrait(LocalConfiguration.current, MaterialTheme.dimens.outerPadding, showAllSections)

    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Green7),
        ) {
            if (showAllSections) {
                GameScreenTop(
                    singlePartHeight = uiSectionSizes.singlePartHeight,
                    dataNumber = currentState.numberCurrentRecord,
                    dataScore = currentState.scoreCurrentRecord,
                    isLoading = isLoading,
                    modifier = Modifier.height(uiSectionSizes.topHeight)
                )
            }

            BoardGame(
                tableData = currentState.board,
                currentDirection = currentDirection,
                boardGameSize = uiSectionSizes.boardGameSize,
                isLoading = isLoading,
                modifier = Modifier.height(uiSectionSizes.boardGameHeight)
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
                    boardGameHeight = uiSectionSizes.boardGameHeight,
                    singlePartHeight = uiSectionSizes.singlePartHeight,
                    modifier = Modifier.fillMaxWidth(),
                    onAction = onAction
                )
            }
        }
    }
}

fun getUiSectionSizesPortrait(
    configuration: Configuration,
    outerPadding: Dp,
    showAllSections: Boolean
): UiSectionSizesPortrait {
    val totalHeight = configuration.screenHeightDp.dp

    val singlePartHeight = totalHeight.times(0.1f)
    val topHeight = totalHeight.times(0.3f)
    val bottomHeight = totalHeight.times(0.2f)
    val boardGameHeight = totalHeight.times(if (showAllSections) 0.5f else 1f)

    val width = configuration.screenWidthDp.dp.minus(outerPadding + outerPadding)
    val boardGameSize = if (width <= boardGameHeight) width else boardGameHeight

    return UiSectionSizesPortrait(
        singlePartHeight = singlePartHeight,
        topHeight = topHeight,
        boardGameHeight = boardGameHeight,
        boardGameSize = boardGameSize,
        bottomHeight = bottomHeight,
    )
}

data class UiSectionSizesPortrait(
    val singlePartHeight: Dp,
    val topHeight: Dp,
    val boardGameHeight: Dp,
    val boardGameSize: Dp,
    val bottomHeight: Dp
)