package com.example.two_zero_four_eight

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation.ui.menu.MenuScreenRoot
import com.example.two_zero_four_eight.presentation_old.ui.Screen.*
import com.example.two_zero_four_eight.presentation_old.ui.game.GameAction.*
import com.example.two_zero_four_eight.presentation_old.ui.game.GameStatus.*
import com.example.two_zero_four_eight.presentation_old.ui.game.GameViewModel
import com.example.two_zero_four_eight.presentation_old.ui.game.screens.GameScreenRoot
import com.example.two_zero_four_eight.presentation_old.ui.records.RecordsScreenRoot
import com.example.two_zero_four_eight.presentation_old.ui.win_or_lose.BottomButtonGameOver
import com.example.two_zero_four_eight.presentation_old.ui.win_or_lose.BottomButtonYouWin
import com.example.two_zero_four_eight.presentation_old.ui.win_or_lose.WinOrLoseScreen

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    val viewModel: GameViewModel = viewModel()

    val goBackFromGameOver : () -> Unit = {
        navController.popBackStack()
        viewModel.onAction(OnStartGame())
    }

    val goBackFromYouWin : () -> Unit = {
        navController.popBackStack()
        viewModel.updateCurrentGameStatus(PLAYING)
    }

    NavHost(
        navController = navController,
        startDestination = Menu
    ) {
        composable<Menu> {
            MenuScreenRoot(
                onStartGame = { size ->
                    viewModel.onAction(OnStartGame(
                        size = size,
                        deletePreviousState = true
                    ))
                    navController.navigate(Game)
                },
                onRecords = {
                    navController.navigate(Records)
                }
            )
        }
        composable<Records> {
            RecordsScreenRoot()
        }
        composable<Game> {
            GameScreenRoot(
                viewModel = viewModel,
                onGameOver = { numbers, scores, numberToWin ->
                    navController.navigate(
                        GameOver(
                            currentScore = scores.currentValue,
                            recordScore = scores.recordValue,
                            currentNumber = numbers.currentValue,
                            recordNumber = numbers.recordValue,
                            numberToWin = numberToWin
                        )
                    )
                },
                onYouWin = { numbers, scores ->
                    navController.navigate(
                        YouWin(
                            currentScore = scores.currentValue,
                            recordScore = scores.recordValue,
                            currentNumber = numbers.currentValue,
                            recordNumber = numbers.recordValue,
                        )
                    )
                }
            )
        }
        composable<GameOver> {
            val args = it.toRoute<GameOver>()
            WinOrLoseScreen(
                titleRes = R.string.game_over_title,
                numberToShow = args.numberToWin,
                numberCurrentRecord = CurrentRecordData(args.currentNumber, args.recordNumber),
                scoreCurrentRecord = CurrentRecordData(args.currentScore, args.recordScore),
                onBackButtonPressed = goBackFromGameOver,
                bottomButton = {
                    BottomButtonGameOver(
                        goBackFromGameOver = goBackFromGameOver
                    )
                }
            )
        }
        composable<YouWin> {
            val args = it.toRoute<YouWin>()
            WinOrLoseScreen(
                titleRes = R.string.you_win_title,
                numberToShow = args.currentNumber,
                numberCurrentRecord = CurrentRecordData(args.currentNumber, args.recordNumber),
                scoreCurrentRecord = CurrentRecordData(args.currentScore, args.recordScore),
                onBackButtonPressed = goBackFromYouWin,
                bottomButton = {
                    BottomButtonYouWin(
                        goBackFromYouWin = goBackFromYouWin
                    )
                }
            )
        }
    }
}