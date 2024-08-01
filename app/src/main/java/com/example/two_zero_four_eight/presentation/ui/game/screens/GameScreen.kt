package com.example.two_zero_four_eight.presentation.ui.game.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.two_zero_four_eight.presentation.ui.game.GameState
import com.example.two_zero_four_eight.presentation.ui.game.TwoZeroFourEightViewModel
import com.example.two_zero_four_eight.presentation.design_system.isBothCompact
import com.example.two_zero_four_eight.presentation.design_system.isPortrait
import com.example.two_zero_four_eight.presentation.design_system.movements.MovementDirection.*

@Composable
fun GameScreen(viewModel: TwoZeroFourEightViewModel, uiState: GameState) {
    var currentDirection by remember { mutableStateOf(NONE) }
    val showAllSections = !MaterialTheme.isBothCompact

    if (MaterialTheme.isPortrait) {
        GameScreenPortrait(uiState.currentState, currentDirection, showAllSections, uiState.isLoading,
            setCurrentDirection = { currentDirection = it },
            moveNumbers = { viewModel.moveNumbers(it) },
            previousBoard = { viewModel.previousBoard() },
            startNewGame = { viewModel.startNewGame() }
        )
    } else {
        GameScreenLandscape(uiState.currentState, currentDirection, showAllSections, uiState.isLoading,
            setCurrentDirection = { currentDirection = it },
            moveNumbers = { viewModel.moveNumbers(it) },
            previousBoard = { viewModel.previousBoard() },
            startNewGame = { viewModel.startNewGame() }
        )
    }
}