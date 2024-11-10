package com.example.two_zero_four_eight.presentation.ui.game

import com.example.two_zero_four_eight.presentation.ui.game.GameStatus.*
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.domain.models.IndividualBestValues
import com.example.two_zero_four_eight.domain.use_cases.copy

data class GameState(
    val simpleBoard : List<Int> = emptyList(),
    var currentState: SingleGameState = SingleGameState(),
    var previousState: SingleGameState? = null,
    var originalBestValues: IndividualBestValues = IndividualBestValues(),
    var isLoading: Boolean = false,
    var boardSize: Int = -1
)

data class SingleGameState(
    var board: MutableList<MutableList<Int>> = mutableListOf(),
    var gameStatus: GameStatus = PLAYING,
    var numberToWin: Int = DEFAULT_NUMBER_TO_WIN,
    var numberCurrentRecord: CurrentRecordData = CurrentRecordData(),
    var scoreCurrentRecord: CurrentRecordData = CurrentRecordData()
) {
    fun clone(): SingleGameState {
        return copy(
            board = board.copy(),
            gameStatus = gameStatus,
            numberToWin = numberToWin,
            numberCurrentRecord = numberCurrentRecord.copy(),
            scoreCurrentRecord = scoreCurrentRecord.copy()
        )
    }
}

enum class GameStatus {
    PLAYING,
    GAME_OVER,
    YOU_WIN
}