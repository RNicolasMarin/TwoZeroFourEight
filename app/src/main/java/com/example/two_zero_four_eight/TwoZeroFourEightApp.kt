package com.example.two_zero_four_eight

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.two_zero_four_eight.presentation.ui.game.screens.GameScreen
import com.example.two_zero_four_eight.presentation.ui.game.TwoZeroFourEightViewModel

@Composable
fun TwoZeroFourEightApp() {

    val viewModel: TwoZeroFourEightViewModel = viewModel()
    val uiState by viewModel.gameState.collectAsState()

    GameScreen(viewModel, uiState)
}
