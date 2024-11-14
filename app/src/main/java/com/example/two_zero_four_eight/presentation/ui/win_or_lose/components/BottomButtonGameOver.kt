package com.example.two_zero_four_eight.presentation.ui.win_or_lose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.two_zero_four_eight.presentation.design_system.components.IconButtonStartAgain

@Composable
fun BottomButtonGameOver(
    goBackFromGameOver : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButtonStartAgain(
            onClick = goBackFromGameOver
        )
    }
}