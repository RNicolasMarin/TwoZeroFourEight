package com.example.two_zero_four_eight.presentation.design_system

import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.min
import com.example.two_zero_four_eight.presentation.design_system.ScreenContentOrientation.*

data class ScreenConfiguration(
    /*val screenContent: ScreenContent,
    val screenOrientation: ScreenOrientation,*/
    val screenContentOrientation: ScreenContentOrientation,
    val dimens: Dimens = Dimens(),
    val typographies: Typographies = Typographies()
)

enum class ScreenContentOrientation {
    PORTRAIT,
    LANDSCAPE,
    SIMPLIFIED
}

/*enum class ScreenOrientation {
    PORTRAIT,
    LANDSCAPE
}

enum class ScreenContent {
    FULL,//it shows everything
    SIMPLIFIED//it shows less composable (for split screens)
}

fun Configuration.getScreenOrientation(screenContent: ScreenContent): ScreenOrientation {
    return when (orientation) {
        ORIENTATION_LANDSCAPE -> if (screenContent == SIMPLIFIED) PORTRAIT else LANDSCAPE
        else -> PORTRAIT
    }
}

fun Configuration.getScreenContent(): ScreenContent {
    return if (screenHeightDp.dp <= 480.dp && screenWidthDp.dp <= 600.dp) return SIMPLIFIED else FULL
}*/

fun Configuration.getScreenContentOrientation() : ScreenContentOrientation {
    val height = screenHeightDp.dp
    val width = screenWidthDp.dp

    val higherSize = max(height, width)
    val lowerSize = min(height, width)
    return when {
        /*height <= minScreenWidth && width <= minScreenHeightIncludingSimplified -> SIMPLIFIED
        height <= minScreenHeightIncludingSimplified && width <= minScreenWidth -> SIMPLIFIED*/
        higherSize - 100.dp <= lowerSize -> SIMPLIFIED
        orientation == ORIENTATION_LANDSCAPE -> LANDSCAPE
        else -> PORTRAIT
    }
}
