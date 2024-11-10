package com.example.two_zero_four_eight.presentation.ui.game

import com.example.two_zero_four_eight.domain.models.CurrentRecordData

sealed interface GameEvent {

    data class GameOver(
        val numberCurrentRecord: CurrentRecordData,
        val scoreCurrentRecord: CurrentRecordData,
        val numberToWin: Int
    ): GameEvent

    data class YouWin(
        val numberCurrentRecord: CurrentRecordData,
        val scoreCurrentRecord: CurrentRecordData
    ): GameEvent
}