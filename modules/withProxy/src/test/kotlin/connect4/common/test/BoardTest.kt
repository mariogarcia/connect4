package connect4.common.test

import connect4.common.model.Board
import org.junit.jupiter.api.BeforeEach

abstract class BoardTest(private val rows: Int, private val cols: Int, private val winningMoves: Int) {
    protected var board = Board(rows, cols, winningMoves)

    @BeforeEach
    fun initBoard() {
        this.board = Board(rows, cols, winningMoves)
    }
}