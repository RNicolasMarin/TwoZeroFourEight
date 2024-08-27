package com.example.two_zero_four_eight.domain.repositories

import com.example.two_zero_four_eight.domain.models.IndividualBestValues
import com.example.two_zero_four_eight.data.local.entities.RecordValues
import com.example.two_zero_four_eight.domain.models.Record

interface RecordRepository {

    suspend fun getIndividualBestValues(boardSize: Int): IndividualBestValues?

    suspend fun getRecordsForBoard(boardSize: Int): List<RecordValues>

    suspend fun insertRecord(record: RecordValues)

    suspend fun updateRecord(record: RecordValues)

    suspend fun getRecordsWithSizesAndSortedByScore(sizes: List<Int>): List<Record>

    suspend fun getRecordsWithSizesAndSortedByNumber(sizes: List<Int>): List<Record>

}