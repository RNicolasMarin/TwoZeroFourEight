package com.example.two_zero_four_eight.presentation_old.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.two_zero_four_eight.R
import com.example.two_zero_four_eight.presentation_old.design_system.Green2
import com.example.two_zero_four_eight.presentation_old.design_system.White
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld

@Composable
fun AppName(
    text: String = stringResource(id = R.string.app_name),
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(MaterialTheme.dimensOld.corners),
                color = Green2
            )
    ) {
        Text(
            text = text,
            color = White,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.dimensOld.nameHorizontalPadding)
        )
    }
}


