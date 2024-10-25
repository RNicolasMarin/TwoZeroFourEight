package com.example.two_zero_four_eight.presentation_old.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.two_zero_four_eight.presentation_old.design_system.Green2
import com.example.two_zero_four_eight.presentation_old.design_system.White
import com.example.two_zero_four_eight.presentation_old.design_system.dimens

@Composable
fun WideButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(MaterialTheme.dimens.corners),
                color = Green2
            )
    ) {
        Text(
            text = text,
            color = White,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.dimens.nameHorizontalPadding)
        )
    }
}