package com.example.two_zero_four_eight.presentation_old.ui.records.components

import com.example.two_zero_four_eight.domain.models.BoardSize

data class FilterOption(
    val size: BoardSize,
    var selected: Boolean
)