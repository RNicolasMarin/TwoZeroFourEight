package com.example.two_zero_four_eight.presentation_old.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.presentation_old.design_system.Green7
import com.example.two_zero_four_eight.presentation_old.design_system.components.AppName
import com.example.two_zero_four_eight.presentation_old.design_system.components.IconButton
import com.example.two_zero_four_eight.presentation_old.design_system.components.WideButton
import com.example.two_zero_four_eight.presentation_old.design_system.dimens
import com.example.two_zero_four_eight.presentation_old.design_system.movements.MovementDirection
import com.example.two_zero_four_eight.presentation_old.ui.game.components.BoardGame
import com.example.two_zero_four_eight.presentation_old.ui.game.screens.getUiSectionSizesPortrait
import com.example.two_zero_four_eight.presentation_old.ui.menu.MenuAction.*

@Composable
fun MenuScreenRoot(
    onStartGame: (Int) -> Unit,
    onRecords: () -> Unit,
    viewModel: MenuViewModel = hiltViewModel()
) {
    MenuScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                is OnStartGame -> onStartGame(action.size)
                is OnRecords -> onRecords()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun MenuScreen(
    state: MenuState,
    onAction: (MenuAction) -> Unit
) {
    val innerPadding = MaterialTheme.dimens.innerPadding
    val uiSectionSizes = getUiSectionSizesPortrait(LocalConfiguration.current, MaterialTheme.dimens.outerPadding, true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green7)
            .padding(MaterialTheme.dimens.winOrLosePadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        BoardGame(
            tableData = state.boardSize.cells,
            currentDirection = MovementDirection.NONE,
            boardGameSize = 270.dp,
            isLoading = false
        )
        
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                size = uiSectionSizes.singlePartHeight - innerPadding,
                iconResource = R.drawable.undo_move_2,
                rotate = -45f,
                contentDescription = stringResource(id = R.string.start_again_button_description),
                onClick = {
                    onAction(OnPreviousSize)
                }
            )

            AppName(
                text = "${state.boardSize.size}X${state.boardSize.size}",
                modifier = Modifier.height(uiSectionSizes.singlePartHeight - innerPadding)
            )

            IconButton(
                size = uiSectionSizes.singlePartHeight - innerPadding,
                iconResource = R.drawable.undo_move_2,
                invert = true,
                rotate = -45f,
                contentDescription = stringResource(id = R.string.start_again_button_description),
                onClick = {
                    onAction(OnNextSize)
                }
            )
        }

        Spacer(modifier = Modifier.height(50.dp))


        WideButton(
            text = stringResource(id = R.string.button_start_game),
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAction(OnStartGame(state.boardSize.size))
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        WideButton(
            text = stringResource(id = R.string.button_records),
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onAction(OnRecords)
            }
        )
    }
}