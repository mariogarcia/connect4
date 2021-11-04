package connect4.common.model

import connect4.common.test.BoardTest
import connect4.common.test.Fast
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

@Fast
internal class Connect4BoardTest: BoardTest(rows = 7, cols = 6, winningMoves = 4) {
    @Test
    fun `given a new board, there should be 7x6 cells with NULL color`() {
        val rows: List<Array<Color>> = this.board.getBoardColors()

        assertThat(rows.size, equalTo(7))
        assertThat(rows, everyItem(arrayWithSize(6)))
        assertThat(getCellList(rows), everyItem(`is`(Color.NULL)))
    }

    private fun getCellList(board: List<Array<Color>>) = board.flatMap { it.toList() }
}