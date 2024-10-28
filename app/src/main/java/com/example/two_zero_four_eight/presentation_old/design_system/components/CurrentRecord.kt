package com.example.two_zero_four_eight.presentation_old.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.domain.models.CurrentRecordData
import com.example.two_zero_four_eight.presentation_old.design_system.Black
import com.example.two_zero_four_eight.presentation_old.design_system.Green3
import com.example.two_zero_four_eight.presentation_old.design_system.White
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld
import com.example.two_zero_four_eight.presentation_old.design_system.shimmerEffect

/**
 * It shows the name, current and record values for number or score.
 * **/
@Composable
fun CurrentRecord(
    data: CurrentRecordData,
    name: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(MaterialTheme.dimensOld.corners)
    Box(modifier = modifier) {
        if (isLoading) {
            Box(modifier = modifier.shimmerEffect(shape))
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .background(
                        color = Green3,
                        shape = shape
                    )
                    .padding(
                        horizontal = MaterialTheme.dimensOld.currentRecordPaddingHorizontal,
                        vertical = MaterialTheme.dimensOld.currentRecordPaddingVertical,
                    )
            ) {
                Text(
                    text = name,
                    color = Black,
                    style = MaterialTheme.typography.titleMedium
                )
                Row {
                    CurrentRecordSection(
                        title = stringResource(id = R.string.current_label),
                        value = data.currentValue
                    )

                    Spacer(modifier = Modifier.width(MaterialTheme.dimensOld.currentRecordPaddingBetween))

                    CurrentRecordSection(
                        title = stringResource(id = R.string.record_label),
                        value = data.recordValue
                    )
                }
            }
        }
    }
}

@Composable
fun CurrentRecordSection(
    title: String,
    value: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Black,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.weight(1F)
        )
        Text(
            text = value.toString(),
            color = White,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.weight(1F)
        )
    }
}

