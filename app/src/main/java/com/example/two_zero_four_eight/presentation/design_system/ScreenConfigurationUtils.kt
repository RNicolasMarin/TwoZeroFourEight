package com.example.two_zero_four_eight.presentation.design_system

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun ProvideScreenConfiguration(
    screenConfiguration: ScreenConfiguration,
    content: @Composable () -> Unit
) {
    val screenConfigurationSet = remember { screenConfiguration }
    CompositionLocalProvider(
        LocalScreenConfiguration provides screenConfigurationSet,
        content = content
    )
}

private val LocalScreenConfiguration = staticCompositionLocalOf {
    ScreenConfiguration(
        screenContentOrientation = ScreenContentOrientation.PORTRAIT
    )
}

val MaterialTheme.screenConfiguration: ScreenConfiguration
    @Composable
    get() = LocalScreenConfiguration.current

val MaterialTheme.screenContentOrientation: ScreenContentOrientation
    @Composable
    get() = LocalScreenConfiguration.current.screenContentOrientation

val MaterialTheme.dimens: Dimens
    @Composable
    get() = LocalScreenConfiguration.current.dimens

val MaterialTheme.typographies: Typographies
    @Composable
    get() = LocalScreenConfiguration.current.typographies