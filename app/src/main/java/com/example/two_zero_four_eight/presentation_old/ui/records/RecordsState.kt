package com.example.two_zero_four_eight.presentation_old.ui.records

import com.example.two_zero_four_eight.domain.models.Record
import com.example.two_zero_four_eight.presentation_old.ui.records.components.FilterOption
import com.example.two_zero_four_eight.presentation_old.ui.records.components.RecordsButtonsState
import com.example.two_zero_four_eight.presentation_old.ui.records.components.RecordsButtonsState.*
import com.example.two_zero_four_eight.presentation_old.ui.records.components.Sort
import com.example.two_zero_four_eight.presentation_old.ui.records.components.Sort.*
import com.example.two_zero_four_eight.presentation_old.ui.records.components.SortOption

data class RecordsState(
    var buttonsState: RecordsButtonsState = NONE,
    var filterOptions: List<FilterOption> = listOf(),
    var sortOptions: List<SortOption> = listOf(),
    var selectedSortOption: Sort = NUMBER,
    var isLoading: Boolean = false,
    var records: List<Record> = listOf(),
)
