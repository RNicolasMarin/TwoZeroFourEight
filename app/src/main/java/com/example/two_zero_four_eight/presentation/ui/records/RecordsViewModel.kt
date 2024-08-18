package com.example.two_zero_four_eight.presentation.ui.records

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.two_zero_four_eight.domain.models.BoardSize
import com.example.two_zero_four_eight.presentation.ui.records.RecordsAction.*
import com.example.two_zero_four_eight.presentation.ui.records.components.FilterOption
import com.example.two_zero_four_eight.presentation.ui.records.components.RecordsButtonsState
import com.example.two_zero_four_eight.presentation.ui.records.components.RecordsButtonsState.*
import com.example.two_zero_four_eight.presentation.ui.records.components.Sort
import com.example.two_zero_four_eight.presentation.ui.records.components.SortOption
import kotlinx.coroutines.launch

class RecordsViewModel : ViewModel() {

    var state by mutableStateOf(RecordsState())
        private set

    init {
        val filterOptions = BoardSize.entries.map { FilterOption(it, false) }
        val sortOptions   = Sort.entries.map { SortOption(it, it == Sort.NUMBER) }

        viewModelScope.launch {
            state = state.copy(
                filterOptions = filterOptions,
                sortOptions = sortOptions
            )
        }
    }

    fun onAction(action: RecordsAction) = viewModelScope.launch {
        when (action) {
            is OnFilterChecked -> {
                state = state.copy(
                    filterOptions = state.filterOptions.mapIndexed { index, filterOption ->
                        val selected = filterOption.selected
                        filterOption.copy(
                            selected = if (index == action.position) !selected else selected
                        )
                    }
                )
            }

            is OnSortChecked -> {
                val sortOptions = state.sortOptions
                val option = sortOptions[action.position]

                if (option.selected) return@launch

                state = state.copy(
                    sortOptions = sortOptions.mapIndexed { index, sortOption ->
                        sortOption.copy(
                            selected = index == action.position
                        )
                    },
                    selectedSortOption = option.sort
                )
            }

            is OnButtonStateChanged -> {
                when (action.state) {
                    FILTER -> changeStateToNoneOrSpecificState(FILTER)
                    SORT -> changeStateToNoneOrSpecificState(SORT)
                    NONE -> Unit
                }
            }
        }
    }

    private fun changeStateToNoneOrSpecificState(buttonState: RecordsButtonsState) {
        val newState = if (state.buttonsState == buttonState) NONE else buttonState
        state = state.copy(
            buttonsState = newState
        )
    }

}