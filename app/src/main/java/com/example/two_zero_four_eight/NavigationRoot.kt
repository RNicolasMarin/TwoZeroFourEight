package com.example.two_zero_four_eight

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.two_zero_four_eight.presentation.ui.game.screens.GameScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "game"
    ) {
        composable(route = "game") {
            GameScreenRoot(
                onGameOver = {}
            )
        }
    }
}