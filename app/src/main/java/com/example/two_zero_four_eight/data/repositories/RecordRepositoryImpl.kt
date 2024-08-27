package com.example.two_zero_four_eight.data.repositories

import com.example.two_zero_four_eight.data.local.daos.RecordDao
import com.example.two_zero_four_eight.domain.models.IndividualBestValues
import com.example.two_zero_four_eight.data.local.entities.RecordValues
import com.example.two_zero_four_eight.domain.models.Record
import com.example.two_zero_four_eight.domain.repositories.RecordRepository

class RecordRepositoryImpl(
    private val dao: RecordDao
): RecordRepository {

    override suspend fun getIndividualBestValues(boardSize: Int): IndividualBestValues? {
        return dao.getIndividualBestValues(boardSize)
    }

    override suspend fun getRecordsForBoard(boardSize: Int): List<RecordValues> {
        return dao.getRecordsForBoard(boardSize)
    }

    override suspend fun insertRecord(record: RecordValues) {
        dao.insertRecord(record)
    }

    override suspend fun updateRecord(record: RecordValues) {
        dao.updateRecord(record)
    }

    override suspend fun getRecordsWithSizesAndSortedByScore(sizes: List<Int>): List<Record> {
        return dao.getRecordsWithSizesAndSortedByScore(sizes).map {
            Record(score = it.score, number = it.number, boardSize = it.boardSize)
        }
    }

    override suspend fun getRecordsWithSizesAndSortedByNumber(sizes: List<Int>): List<Record> {
        return dao.getRecordsWithSizesAndSortedByNumber(sizes).map {
            Record(score = it.score, number = it.number, boardSize = it.boardSize)
        }
    }

}