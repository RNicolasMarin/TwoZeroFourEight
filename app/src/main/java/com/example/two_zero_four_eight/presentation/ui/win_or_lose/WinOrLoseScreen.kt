package com.example.two_zero_four_eight.presentation.ui.win_or_lose

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation.design_system.Black
import com.example.two_zero_four_eight.presentation.design_system.Green7
import com.example.two_zero_four_eight.presentation.design_system.components.AppName
import com.example.two_zero_four_eight.presentation.design_system.components.CurrentRecord
import com.example.two_zero_four_eight.presentation.design_system.dimens

@Composable
fun WinOrLoseScreen(
    @StringRes titleRes: Int,
    numberToShow: Int,
    numberCurrentRecord: CurrentRecordData,
    scoreCurrentRecord: CurrentRecordData,
    onBackButtonPressed: () -> Unit,
    bottomButton: @Composable () -> Unit
) {
    BackHandler {
        // Custom back button behavior
        onBackButtonPressed()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green7)
            .padding(MaterialTheme.dimens.winOrLosePadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = titleRes),
            color = Black,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(50.dp))

        AppName(
            text = turnNumberToAtLeastFourDigits(numberToShow.toString()),
            modifier = Modifier.height(110.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        CurrentRecord(
            data = numberCurrentRecord,
            name = stringResource(id = R.string.current_record_number_label),
            isLoading = false,
            modifier = Modifier
                .widthIn(
                    min = MaterialTheme.dimens.currentRecordWidthMin,
                    max = MaterialTheme.dimens.currentRecordWidthMax
                )
                .height(50.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CurrentRecord(
            data = scoreCurrentRecord,
            name = stringResource(id = R.string.current_record_score_label),
            isLoading = false,
            modifier = Modifier
                .widthIn(
                    min = MaterialTheme.dimens.currentRecordWidthMin,
                    max = MaterialTheme.dimens.currentRecordWidthMax
                )
                .height(50.dp)
        )

        bottomButton()
    }
}

fun turnNumberToAtLeastFourDigits(number: String): String {
    return when (number.length) {
        1 -> "  $number  "
        2, 3 -> " $number "
        else -> number
    }
}
