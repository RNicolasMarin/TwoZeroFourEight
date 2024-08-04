package com.example.two_zero_four_eight.presentation.ui.game.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.two_zero_four_eight.presentation.ui.game.GameStatus.*
import com.example.two_zero_four_eight.presentation.ui.game.SingleGameState
import com.example.two_zero_four_eight.presentation.ui.game.screens.UiSectionSizesLandscape

/**
 * Component used to render the left side of the screen on landscape.
 * **/
@Composable
fun GameScreenLeft(
    uiState: SingleGameState,
    uiSectionSizes: UiSectionSizesLandscape,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        GameScreenTop(
            singlePartHeight = uiSectionSizes.singlePartHeight,
            dataNumber = uiState.numberCurrentRecord,
            dataScore = uiState.scoreCurrentRecord,
            isLoading = isLoading,
            modifier = Modifier.height(uiSectionSizes.topHeight)
        )
        if (uiState.gameStatus != GAME_OVER) {
            GameScreenBottom(
                gameStatus = uiState.gameStatus,
                singlePartHeight = uiSectionSizes.singlePartHeight,
            )
        }
    }
}