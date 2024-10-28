package com.example.two_zero_four_eight.presentation.ui.menu

import com.example.two_zero_four_eight.domain.models.BoardSize
import com.example.two_zero_four_eight.domain.models.BoardSize.*

data class MenuState(
    var boardSize: BoardSize = THREE_X_THREE
)
