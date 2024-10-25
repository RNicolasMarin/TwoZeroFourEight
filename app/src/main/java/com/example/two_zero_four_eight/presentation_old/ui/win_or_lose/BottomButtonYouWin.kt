package com.example.two_zero_four_eight.presentation_old.ui.win_or_lose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.presentation_old.design_system.components.WideButton

@Composable
fun BottomButtonYouWin(
    goBackFromYouWin : () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        WideButton(
            text = stringResource(id = R.string.continue_button),
            onClick = goBackFromYouWin
        )
    }
}