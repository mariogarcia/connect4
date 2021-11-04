package connect4.common.model

import connect4.common.test.BoardValueSourceConverter
import connect4.common.test.Fast
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.ValueSource

@Fast
internal class BoardTest {
    @Test
    fun `given a new board, there should be 7x6 cells with NULL color`() {
        val board = Board()
        val rows: List<Array<Color>> = board.getBoardColors()
        assertThat(rows.size, equalTo(7))
        assertThat(rows, everyItem(arrayWithSize(6)))
        assertThat(getCellList(rows), everyItem(`is`(Color.NULL)))
    }

    private fun getCellList(board: List<Array<Color>>) = board.flatMap { it.toList() }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -        
    """])
    fun `given an empty board, there is NOT connect4`(
            @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertFalse(board.isConnect4())
    }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, -
        R, R, R, R, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
    """])
    fun `given a board, when there is a row with 4 subsequent cells with same color, there is connect4`(
        @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertTrue(board.isConnect4())
    }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, R, -, -, -
        -, -, R, -, -, -
        -, -, R, -, -, -
        -, -, R, -, -, -
        -, -, -, -, -, -
    """])
    fun `given a board, when there is a column with 4 subsequent cells with same color, there is connect4`(
            @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertTrue(board.isConnect4())
    }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, R, -, -, -, -
        -, -, R, -, -, -
        -, -, -, R, -, -
        -, -, -, -, R, -
        -, -, -, -, -, -        
    """])
    fun `given a board, when there is a diagonal cells with same color, there is connect4`(
            @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertTrue(board.isConnect4())
    }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, R
        -, -, -, -, R, -
        -, -, -, R, -, -
        -, -, R, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
    """])
    fun `given a board, when there is an inverse diagonal cells with same color, there is connect4`(
            @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertTrue(board.isConnect4())
    }

    @ParameterizedTest
    @ValueSource(strings = ["""
        -, -, -, -, -, =
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, R, R, R, -
        -, -, -, -, -, -
        -, -, -, -, -, -
        -, -, -, -, -, -
    """])
    fun `given a board, when there are less than 4 subsequent cells with same color, there is NOT connect4`(
            @ConvertWith(BoardValueSourceConverter::class) board: Board
    ) {
        assertFalse(board.isConnect4())
    }
}