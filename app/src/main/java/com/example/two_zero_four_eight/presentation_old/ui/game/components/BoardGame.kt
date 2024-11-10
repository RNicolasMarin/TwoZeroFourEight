package com.example.two_zero_four_eight.presentation_old.ui.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.two_zero_four_eight.domain.use_cases.DEFAULT_VALUE
import com.example.two_zero_four_eight.presentation_old.design_system.Black
import com.example.two_zero_four_eight.presentation_old.design_system.dimensOld
import com.example.two_zero_four_eight.presentation_old.design_system.movements.MovementDirection
import com.example.two_zero_four_eight.presentation_old.design_system.shimmerEffect

/**
 * It renders the board game with empty cells and cells with numbers.
 * [currentDirection] is needed to refresh the board. Check how to fix this bug.
 * **/
@Composable
fun BoardGameOld(
    tableData: List<List<Int>>,
    currentDirection: MovementDirection,
    boardGameSize: Dp,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {
    val boardInnerPadding = MaterialTheme.dimensOld.boardInnerPadding
    val shape = RoundedCornerShape(MaterialTheme.dimensOld.corners)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        if (isLoading) {
            Box(modifier = Modifier.size(boardGameSize).padding(boardInnerPadding).shimmerEffect(shape))
        } else {
            /*BoardGame(
                boardSize = 3,
                data = tableData,
                modifier = Modifier
                .size(boardGameSize))*/
            /*LazyColumn(
                modifier = Modifier
                    .size(boardGameSize)
                    .background(
                        color = Grey2,
                        shape = shape
                    )
                    .padding(boardInnerPadding)
            ) {
                items(
                    items = tableData,
                ) { row ->
                    BoardGameRow(rowData = row, boardGameSize - boardInnerPadding.times(2))
                }
            }*/
        }
    }
}

@Composable
fun BoardGameRow(rowData: List<Int>, uiBoardSize: Dp) {
    val uiCellSize = uiBoardSize.div(rowData.size)

    LazyRow(
        modifier = Modifier
            .width(uiBoardSize)
            .height(uiCellSize)
    ) {
        items(
            items = rowData,
        ) { cellData ->
            BoardGameCell(cellData, uiCellSize)
        }
    }
}

@Composable
fun BoardGameCell(cellNumber: Int, uiCellSize: Dp) {
    val cellData = getCellData(cellNumber)
    Box(modifier = Modifier
        .width(uiCellSize)
        .height(uiCellSize)
        .padding(MaterialTheme.dimensOld.boardInnerPadding)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    shape = RoundedCornerShape(MaterialTheme.dimensOld.corners),
                    color = cellData.backgroundColor
                )
                .border(
                    shape = RoundedCornerShape(MaterialTheme.dimensOld.corners),
                    color = Black,
                    width = 1.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (cellNumber == DEFAULT_VALUE) "" else cellNumber.toString(),
                color = cellData.textColor,
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}