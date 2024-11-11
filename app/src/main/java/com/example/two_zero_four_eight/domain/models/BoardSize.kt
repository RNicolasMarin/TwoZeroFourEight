package com.example.two_zero_four_eight.domain.models

import com.example.two_zero_four_eight.domain.use_cases.DEFAULT_VALUE

enum class BoardSize(val size: Int, val cells: List<List<Int>>) {
    THREE_X_THREE(3, threeXThree),
    FOUR_X_FOUR(4, fourXFour),
    FIVE_X_FIVE(5, fiveXFive),
    SIX_X_SIX(6, sixXSix),
    SEVEN_X_SEVEN(7, sevenXSeven),
    EIGHT_X_EIGHT(8, eightXEight),
}

fun BoardSize.next(): BoardSize {
    val allValues = BoardSize.entries
    val nextIndex = (ordinal + 1) % allValues.size
    return allValues[nextIndex]
}

fun BoardSize.previous(): BoardSize {
    val allValues = BoardSize.entries
    val nextIndex = if (ordinal - 1 >= 0) ordinal - 1 else allValues.size - 1
    return allValues[nextIndex]
}

val threeXThree = listOf(
    listOf(DEFAULT_VALUE,   2,   4),
    listOf(           32,  16,   8),
    listOf(           64, 128, 256)
)

val fourXFour = listOf(
    listOf(DEFAULT_VALUE,    2,    4,    8),
    listOf(          128,   64,   32,   16),
    listOf(          256,  512, 1024, 2048),
    listOf(            8,    4,    2, 4096),
)

val fiveXFive = listOf(
    listOf(DEFAULT_VALUE,    2,    4,    8,   16),
    listOf(          512,  256,  128,   64,   32),
    listOf(         1024, 2048, 4096,    2,    4),
    listOf(          128,   64,   32,   16,    8),
    listOf(          256,  512, 1024, 2048, 4096),
)

val sixXSix = listOf(
    listOf(DEFAULT_VALUE,    2,    4,    8,   16,   32),
    listOf(         2048, 1024,  512,  256,  128,   64),
    listOf(         4096,    2,    4,    8,   16,   32),
    listOf(         2048, 1024,  512,  256,  128,   64),
    listOf(         4096,    2,    4,    8,   16,   32),
    listOf(         2048, 1024,  512,  256,  128,   64),
)

val sevenXSeven = listOf(
    listOf(DEFAULT_VALUE,    2,    4,    8,   16,   32,   64),
    listOf(            2, 4096, 2048, 1024,  512,  256,  128),
    listOf(            4,    8,   16,   32,   64,  128,  256),
    listOf(            8,    4,    2, 4096, 2048, 1024,  512),
    listOf(           16,   32,   64,  128,  256,  512, 1024),
    listOf(           32,   16,    8,    4,    2, 4096, 2048),
    listOf(           64,  128,  256,  512, 1024, 2048, 4096),
)

val eightXEight = listOf(
    listOf(DEFAULT_VALUE,    2,    4,    8,   16,   32,   64,  128),
    listOf(            8,    4,    2, 4096, 2048, 1024,  512,  256),
    listOf(           16,   32,   64,  128,  256,  512, 1024, 2048),
    listOf(          128,   64,   32,   16,    8,    4,    2, 4096),
    listOf(          256,  512, 1024, 2048, 4096,    2,    4,    8),
    listOf(         2048, 1024,  512,  256,  128,   64,   32,   16),
    listOf(         4096,    2,    4,    8,   16,   32,   64,  128),
    listOf(            8,    4,    2, 4096, 2048, 1024,  512,  256),
)