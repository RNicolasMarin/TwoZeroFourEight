package com.example.two_zero_four_eight.presentation.ui

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Game: Screen()

    @Serializable
    data class WinOrLose(
        val currentScore: Int,
        val recordScore: Int,
        val currentNumber: Int,
        val recordNumber: Int,
    ): Screen()
}