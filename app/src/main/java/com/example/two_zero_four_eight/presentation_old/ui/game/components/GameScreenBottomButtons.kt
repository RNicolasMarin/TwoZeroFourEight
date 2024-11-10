package com.example.two_zero_four_eight.presentation_old.ui.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.presentation_old.design_system.components.IconButton
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld
import com.example.two_zero_four_eight.presentation.ui.game.GameAction
import com.example.two_zero_four_eight.presentation.ui.game.GameAction.*

@Composable
fun GameScreenBottomButtons(
    topHeight: Dp,
    boardGameHeight: Dp,
    singlePartHeight: Dp,
    onAction: (GameAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val innerPadding = MaterialTheme.dimensOld.innerPadding
    val offset = topHeight + boardGameHeight + innerPadding
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .offset(y = offset)
    ) {
        IconButton(
            size = singlePartHeight - innerPadding,
            iconResource = R.drawable.undo_move_2,
            contentDescription = stringResource(id = R.string.start_again_button_description),
            onClick = {
                onAction(OnPreviousBoard)
            }
        )

        Spacer(modifier = Modifier.width(innerPadding))

        IconButton(
            size = singlePartHeight - innerPadding,
            iconResource = R.drawable.start_again,
            contentDescription = stringResource(id = R.string.start_again_button_description),
            onClick = {
                onAction(OnStartGame())
            }
        )
    }
}