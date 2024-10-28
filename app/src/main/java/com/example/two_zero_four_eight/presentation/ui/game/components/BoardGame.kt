package com.example.two_zero_four_eight.presentation.ui.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.two_zero_four_eight.presentation.design_system.TwoZeroFourEightTheme
import com.example.two_zero_four_eight.presentation_old.design_system.Grey2

@Composable
fun BoardGame(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(Grey2)
    ) {

    }
}

@Preview(heightDp = 320, widthDp = 240)
@Composable
private fun LabelTextPreview() {
    TwoZeroFourEightTheme {
        BoardGame(
            modifier = Modifier,
        )
    }
}