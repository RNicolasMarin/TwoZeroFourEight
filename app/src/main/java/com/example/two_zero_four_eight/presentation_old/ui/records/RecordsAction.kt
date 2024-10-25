package com.example.two_zero_four_eight.presentation_old.ui.records

import com.example.two_zero_four_eight.presentation_old.ui.records.components.RecordsButtonsState

sealed interface RecordsAction {

    data class OnButtonStateChanged(
        val state: RecordsButtonsState
    ) : RecordsAction

    data class OnFilterChecked(
        val position: Int
    ) : RecordsAction

    data class OnSortChecked(
        val position: Int
    ) : RecordsAction
}