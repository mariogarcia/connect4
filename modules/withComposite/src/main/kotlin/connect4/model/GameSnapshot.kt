package connect4.model

class GameSnapshot(private val board: Board, private val turn: Turn) {
    private var activePlayer: Player = NullPlayer()

    fun getBoard(): Board {
        val restrictions = board.getRestrictions()
        val board = Board(restrictions)
        val players = turn.getPlayers()

        for (i in 0 until restrictions.rows) {
            for (j in 0 until restrictions.cols) {
                val cellColor = board.board[i][j]
                val cellPlayer = players.find { it.color == cellColor } ?: NullPlayer()
                board.fillCell(cellPlayer , Coordinate(i, j))
                this.activePlayer = cellPlayer
            }
        }

        return board
    }

    fun getActivePlayer(): Player {
        return this.activePlayer
    }

    fun getPlayerPutTokens(): Int {
        TODO("implementation")
    }
}