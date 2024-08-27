package com.example.two_zero_four_eight.presentation.ui.records

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.domain.models.Record
import com.example.two_zero_four_eight.presentation.design_system.Black
import com.example.two_zero_four_eight.presentation.design_system.Green3
import com.example.two_zero_four_eight.presentation.design_system.Green5
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

        if (state.records.isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = stringResource(id = R.string.no_records))
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.records.size) {index ->
                    RecordCard(state.records[index])
                }
            }
        }
    }
}

@Composable
fun RecordCard(
    record: Record,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Green5)
                .padding(vertical = 12.dp, horizontal = 20.dp)
        ) {
            RecordCardColumnSection("Score", record.score.toString())
            Spacer(modifier = Modifier.width(8.dp))
            RecordCardColumnSection("Number", record.number.toString())
            Spacer(modifier = Modifier.width(8.dp))
            RecordCardColumnSection("Size", record.boardSize.toString())
        }
    }
}

@Composable
fun RecordCardColumnSection(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RecordCardLabel(label, Modifier)
        Spacer(modifier = Modifier.height(8.dp))
        RecordCardValue(value, Modifier)
    }
}

@Composable
fun RecordCardForGrid(
    record: Record,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Green5)
                .padding(8.dp)
        ) {
            RecordCardRowSection("Score", record.score.toString())
            Spacer(modifier = Modifier.height(8.dp))
            RecordCardRowSection("Number", record.number.toString())
            Spacer(modifier = Modifier.height(8.dp))
            RecordCardRowSection("Size", record.boardSize.toString())
        }
    }
}

@Composable
fun RecordCardLabel(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        color = Green3,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
    )
}

@Composable
fun RecordCardValue(
    text: String,
    modifier: Modifier
) {
    Text(
        text = text,
        color = Black,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.labelLarge,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun RecordCardRowSection(
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RecordCardLabel(label, Modifier.weight(1f))
        RecordCardValue(value, Modifier.weight(1f))
    }
}