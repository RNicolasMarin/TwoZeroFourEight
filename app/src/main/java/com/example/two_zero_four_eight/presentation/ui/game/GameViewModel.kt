package com.example.two_zero_four_eight.presentation.ui.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.two_zero_four_eight.presentation.design_system.movements.MovementDirection
import com.example.two_zero_four_eight.presentation.design_system.movements.MovementDirection.*
import com.example.two_zero_four_eight.domain.use_cases.CreateBoardGameUseCase
import com.example.two_zero_four_eight.domain.use_cases.MoveNumbersUseCase
import com.example.two_zero_four_eight.presentation.ui.game.GameAction.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val DEFAULT_NUMBER_TO_WIN = 16

@HiltViewModel
class GameViewModel @Inject constructor(
    private val boardGameUseCases: CreateBoardGameUseCase,
    private val moveNumbersUseCase: MoveNumbersUseCase
) : ViewModel() {

    var state by mutableStateOf(GameState())
        private set

    init {
        startNewGame()
    }

    fun onAction(action: GameAction) {
        when(action) {
            is OnMoveNumbers -> moveNumbers(action.direction)
            OnPreviousBoard -> previousBoard()
            OnStartGame -> startNewGame()
        }
    }

    private fun startNewGame() = viewModelScope.launch {
        state = state.copy(
            isLoading = true
        )

        val current = state.currentState
        val newBoard = boardGameUseCases.createBoardGame(current, 3)

        state = state.copy(
            currentState = newBoard.currentState,
            previousState = newBoard.previousState,
            originalBestValues = newBoard.originalBestValues,
            isLoading = false
        )
    }

    private fun moveNumbers(direction: MovementDirection) = viewModelScope.launch {
        if (direction == NONE) return@launch

        val newBoard = moveNumbersUseCase.moveNumbers(direction, state)

        state = state.copy(
            currentState = newBoard.currentState,
            previousState = newBoard.previousState,
            originalBestValues = newBoard.originalBestValues
        )
    }

    private fun previousBoard() = viewModelScope.launch {
        val previous = state.previousState ?: return@launch

        state = state.copy(
            currentState = previous.copy(),
            previousState = null,
        )
    }
}