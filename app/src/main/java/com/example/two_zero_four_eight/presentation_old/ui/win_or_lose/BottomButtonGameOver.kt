package com.example.two_zero_four_eight.presentation_old.ui.win_or_lose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.presentation_old.design_system.components.IconButton
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld
import com.example.two_zero_four_eight.presentation_old.ui.game.screens.getUiSectionSizesPortrait

@Composable
fun BottomButtonGameOver(
    goBackFromGameOver : () -> Unit
) {
    val innerPadding = MaterialTheme.dimensOld.innerPadding
    val uiSectionSizes = getUiSectionSizesPortrait(LocalConfiguration.current, MaterialTheme.dimensOld.outerPadding, true)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            size = uiSectionSizes.singlePartHeight - innerPadding,
            iconResource = R.drawable.start_again,
            contentDescription = stringResource(id = R.string.start_again_button_description),
            onClick = goBackFromGameOver
        )
    }
}