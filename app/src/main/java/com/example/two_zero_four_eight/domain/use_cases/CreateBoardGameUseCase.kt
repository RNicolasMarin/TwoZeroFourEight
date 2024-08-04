package com.example.two_zero_four_eight.domain.use_cases

import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation.ui.game.GameState
import com.example.two_zero_four_eight.presentation.ui.game.GameStatus.*
import com.example.two_zero_four_eight.domain.models.IndividualBestValues
import com.example.two_zero_four_eight.presentation.ui.game.SingleGameState
import com.example.two_zero_four_eight.domain.repositories.RecordRepository
import com.example.two_zero_four_eight.presentation.ui.game.DEFAULT_NUMBER_TO_WIN
import kotlinx.coroutines.delay
import javax.inject.Inject

const val DEFAULT_VALUE = -1

class CreateBoardGameUseCase @Inject constructor(
    private val useCase: AddNumberToBoardGameUseCase,
    private val repository: RecordRepository
) {

    /** Initialize the BoardGame matrix (for both dimensions of the size of [size]) to represent
     * the rows and columns with [DEFAULT_VALUE] for each cell as a default value
     *
     * Then adds the first and second number to the boardGame and returns it.
     *
     * Finally makes the request to get the record number and record score for that
     * board size and creates the current state.
     * **/
    suspend fun createBoardGame(previousState: SingleGameState, size: Int): GameState {
        var boardGame = MutableList(size) { //rows
            MutableList(size) { //cells
                DEFAULT_VALUE
            }
        }

        boardGame = useCase.addNumber(boardGame)
        boardGame = useCase.addNumber(boardGame)

        //small delay to show the simmer effect better
        delay(400)

        val individualBestValues = repository.getIndividualBestValues(size) ?: IndividualBestValues()

        return GameState(
            //if there's a previous state it uses it, if not sets a null
            previousState = if (previousState.board.isEmpty() || previousState.gameStatus == GAME_OVER) null else previousState,
            currentState = SingleGameState(
                board = boardGame,
                gameStatus = PLAYING,
                numberToWin = DEFAULT_NUMBER_TO_WIN,
                numberCurrentRecord = CurrentRecordData(recordValue = individualBestValues.number),
                scoreCurrentRecord = CurrentRecordData(recordValue = individualBestValues.score),
            ),
            originalBestValues = individualBestValues
        )
    }
}