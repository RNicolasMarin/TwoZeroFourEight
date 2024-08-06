package com.example.two_zero_four_eight.presentation.ui.game.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation.design_system.ObserveAsEvents
import com.example.two_zero_four_eight.presentation.ui.game.GameState
import com.example.two_zero_four_eight.presentation.ui.game.GameViewModel
import com.example.two_zero_four_eight.presentation.design_system.isBothCompact
import com.example.two_zero_four_eight.presentation.design_system.isPortrait
import com.example.two_zero_four_eight.presentation.design_system.movements.MovementDirection.*
import com.example.two_zero_four_eight.presentation.ui.game.GameAction
import com.example.two_zero_four_eight.presentation.ui.game.GameAction.*
import com.example.two_zero_four_eight.presentation.ui.game.GameEvent.*

@Composable
fun GameScreenRoot(
    onGameOver: (CurrentRecordData, CurrentRecordData, Int) -> Unit,
    onYouWin: (CurrentRecordData, CurrentRecordData) -> Unit,
    viewModel: GameViewModel = hiltViewModel()
){
    ObserveAsEvents(viewModel.events) { event ->
        when (event) {
            is GameOver -> onGameOver(event.numberCurrentRecord, event.scoreCurrentRecord, event.numberToWin)
            is YouWin -> onYouWin(event.numberCurrentRecord, event.scoreCurrentRecord)
        }
    }
    GameScreen(
        state = viewModel.state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@Composable
fun GameScreen(
    state: GameState,
    onAction: (GameAction) -> Unit
) {
    var currentDirection by remember { mutableStateOf(NONE) }
    val showAllSections = !MaterialTheme.isBothCompact

    val onActionValidatingMoves : (GameAction) -> Unit = { action ->
        when(action) {
            is OnMoveNumbers -> { currentDirection = action.direction }
            else -> Unit
        }
        onAction(action)
    }

    if (MaterialTheme.isPortrait) {
        GameScreenPortrait(
            currentState = state.currentState,
            currentDirection = currentDirection,
            showAllSections = showAllSections,
            isLoading = state.isLoading,
            onAction = onActionValidatingMoves
        )
    } else {
        GameScreenLandscape(
            currentState = state.currentState,
            currentDirection = currentDirection,
            showAllSections = showAllSections,
            isLoading = state.isLoading,
            onAction = onActionValidatingMoves,
        )
    }
}