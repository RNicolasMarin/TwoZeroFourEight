package com.example.two_zero_four_eight.presentation.ui.menu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.two_zero_four_eight.presentation.ui.menu.MenuAction.*
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    var state by mutableStateOf(MenuState())
        private set

    fun onAction(action: MenuAction) {
        when (action) {
            OnNextSize -> {
                viewModelScope.launch {
                    val newSize = state.boardSize.next()
                    state = state.copy(boardSize = newSize)
                }
            }
            OnPreviousSize -> {
                viewModelScope.launch {
                    val newSize = state.boardSize.previous()
                    state = state.copy(boardSize = newSize)
                }
            }
            else -> Unit
        }
    }
}