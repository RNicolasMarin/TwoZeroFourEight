package com.example.two_zero_four_eight.presentation.ui.records

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.two_zero_four_eight.presentation.design_system.Green7
import com.example.two_zero_four_eight.presentation.ui.records.components.RecordsButtons

@Composable
fun RecordsScreenRoot(
    viewModel: RecordsViewModel = hiltViewModel(),
) {
    RecordsScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun RecordsScreen(
    state: RecordsState,
    onAction: (RecordsAction) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green7)
            .padding(12.dp),
    ) {
        RecordsButtons(
            state = state,
            onAction = onAction,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Red)
        ) {

        }

    }
}