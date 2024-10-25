package com.example.two_zero_four_eight.use_cases

import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation_old.ui.game.GameState
import com.example.two_zero_four_eight.domain.models.IndividualBestValues
import com.example.two_zero_four_eight.presentation_old.ui.game.SingleGameState
import com.example.two_zero_four_eight.domain.repositories.RecordRepository
import com.example.two_zero_four_eight.domain.use_cases.AddNumberToBoardGameUseCase
import com.example.two_zero_four_eight.domain.use_cases.CreateBoardGameUseCase
import com.example.two_zero_four_eight.domain.use_cases.DEFAULT_VALUE
import com.google.common.truth.Truth.*
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CreateBoardGameUseCaseTest {

    private lateinit var moveNumbersUseCase: CreateBoardGameUseCase
    private lateinit var addNumberToBoardGameUseCase: AddNumberToBoardGameUseCase
    private lateinit var repository: RecordRepository
    private lateinit var previousState: SingleGameState
    private lateinit var actual: GameState

    @Before
    fun setUp() {
        addNumberToBoardGameUseCase = AddNumberToBoardGameUseCase()
        repository = mockk()
        previousState = SingleGameState()
        moveNumbersUseCase = CreateBoardGameUseCase(addNumberToBoardGameUseCase, repository)
    }

    @Test
    fun `Create 3 x 3 BoardGame with record, no previous state`() = runBlocking {
        val individualBestValues = IndividualBestValues(number = 64, score = 400)
        setCoGetIndividualBestValues(individualBestValues)

        actual = moveNumbersUseCase.createBoardGame(previousState, 3)

        checkCurrentSideDetails(recordNumber = 64, recordScore = 400)
        checkSideDetails(individualBestValues)
        checkCurrentBoard()

        verifyCallGetIndividualBestValues()
    }


    @Test
    fun `Create 3 x 3 BoardGame without record, no previous state`() = runBlocking {
        setCoGetIndividualBestValues(null)

        actual = moveNumbersUseCase.createBoardGame(previousState,3)

        checkCurrentSideDetails()
        checkSideDetails(IndividualBestValues())
        checkCurrentBoard()

        verifyCallGetIndividualBestValues()
    }



    //SETTERS, UTILS, ASSERTIONS, VERIFICATIONS
    private fun setCoGetIndividualBestValues(bestValues: IndividualBestValues?) {
        coEvery { repository.getIndividualBestValues(3) } answers {
            bestValues
        }
    }

    private fun checkCurrentSideDetails(recordNumber: Int? = null, recordScore: Int? = null) {
        with(actual.currentState) {
            val number = CurrentRecordData()
            recordNumber?.let { number.recordValue = it }
            assertThat(numberCurrentRecord).isEqualTo(number)

            val score = CurrentRecordData()
            recordScore?.let { score.recordValue = it }
            assertThat(scoreCurrentRecord).isEqualTo(score)
        }
    }

    private fun checkSideDetails(individualBestValues: IndividualBestValues) {
        assertThat(actual.originalBestValues).isEqualTo(individualBestValues)
        assertThat(actual.previousState).isNull()
    }

    private fun checkCurrentBoard() {
        with(actual.currentState.board.flatten()) {
            assertThat(size).isEqualTo(9)

            val emptyCellsAmount = filter { it == DEFAULT_VALUE }.size
            assertThat(emptyCellsAmount).isEqualTo(7)

            val usedCellsAmount = filter { it != DEFAULT_VALUE }.size
            assertThat(usedCellsAmount).isEqualTo(2)
        }
    }

    private fun verifyCallGetIndividualBestValues() {
        verify {
            runBlocking {
                repository.getIndividualBestValues(3)
            }
        }
    }
}