package com.example.two_zero_four_eight

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation.ui.Screen.Game
import com.example.two_zero_four_eight.presentation.ui.Screen.WinOrLose
import com.example.two_zero_four_eight.presentation.ui.game.GameAction.*
import com.example.two_zero_four_eight.presentation.ui.game.GameViewModel
import com.example.two_zero_four_eight.presentation.ui.game.screens.GameScreenRoot
import com.example.two_zero_four_eight.presentation.ui.win_or_lose.BottomButtonLose
import com.example.two_zero_four_eight.presentation.ui.win_or_lose.WinOrLoseScreen

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    val viewModel: GameViewModel = viewModel()

    val goBackToNewGame : () -> Unit = {
        navController.popBackStack()
        viewModel.onAction(OnStartGame)
    }

    NavHost(
        navController = navController,
        startDestination = Game
    ) {
        composable<Game> {
            GameScreenRoot(
                viewModel = viewModel,
                onGameOver = { numbers, scores ->
                    navController.navigate(
                        WinOrLose(
                            currentScore = scores.currentValue,
                            recordScore = scores.recordValue,
                            currentNumber = numbers.currentValue,
                            recordNumber = numbers.recordValue,
                        )
                    )
                }
            )
        }
        composable<WinOrLose> {
            val args = it.toRoute<WinOrLose>()
            WinOrLoseScreen(
                titleRes = R.string.game_over_title,
                numberCurrentRecord = CurrentRecordData(args.currentNumber, args.recordNumber),
                scoreCurrentRecord = CurrentRecordData(args.currentScore, args.recordScore),
                onBackButtonPressed = goBackToNewGame,
                bottomButton = {
                    BottomButtonLose(
                        goBackToNewGame = goBackToNewGame
                    )
                }
            )
        }
    }
}