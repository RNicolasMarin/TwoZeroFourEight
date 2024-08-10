package com.example.two_zero_four_eight.presentation.ui.menu

sealed interface MenuAction {

    data object OnNextSize : MenuAction

    data object OnPreviousSize : MenuAction

    data class OnStartGame(
        val size: Int
    ) : MenuAction
}