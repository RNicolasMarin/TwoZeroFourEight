package com.example.two_zero_four_eight.presentation.design_system.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.two_zero_four_eight.presentation.design_system.Black
import com.example.two_zero_four_eight.presentation.design_system.Green1
import com.example.two_zero_four_eight.presentation.design_system.Green3
import com.example.two_zero_four_eight.presentation.design_system.White
import com.example.two_zero_four_eight.presentation.design_system.dimens

@Composable
fun IconButton(
    onClick: () -> Unit,
    size: Dp,
    contentDescription: String,
    @DrawableRes iconResource: Int,
    invert: Boolean = false,
    rotate: Float = 0f,
    modifier: Modifier = Modifier,
) {

    Button(
        onClick = onClick,
        modifier = modifier
            .size(size)
            .border(
                shape = RoundedCornerShape(MaterialTheme.dimens.corners),
                color = Black,
                width = 1.dp
            ),
        shape = RoundedCornerShape(MaterialTheme.dimens.corners),
        contentPadding = PaddingValues(MaterialTheme.dimens.innerPadding),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green3,
            contentColor = Black,
            disabledContainerColor = Green1,
            disabledContentColor = White
        )
    ) {
        Icon(
            painter = painterResource(iconResource),
            contentDescription = contentDescription,
            tint = White,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(scaleX = if (invert) -1f else 1f)
                .rotate(rotate)
        )
    }
}