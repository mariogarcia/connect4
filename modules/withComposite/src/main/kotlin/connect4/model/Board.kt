package connect4.model

class Board(private val restrictions: BoardRestrictions) {
    var board: Array<Array<Color>> = Array(restrictions.rows) { Array(restrictions.cols) { Color.NULL } }
    var lastMove: Coordinate = NullCoordinate()

    fun reset(): Unit {
        (0 until restrictions.rows).zip(0 until restrictions.cols)
            .forEach { pair: Pair<Int, Int> ->
                fillCell(NullPlayer(), Coordinate(pair.first, pair.second))
            }
    }

    fun fillCell(player: Player, coordinate: Coordinate): Board {
        this.lastMove = coordinate
        this.board[coordinate.row][coordinate.col] = player.color
        return this
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.isEmptyAt(coordinate) && this.isWithinBounds(coordinate)
    }

    private fun isEmptyAt(coordinate: Coordinate): Boolean {
        return this.board[coordinate.row][coordinate.col].isNull()
    }

    private fun isWithinBounds(coordinate: Coordinate): Boolean {
        val rowIsCorrect = coordinate.row >= 0 && coordinate.row < this.restrictions.rows
        val colIsCorrect = coordinate.col >= 0 && coordinate.col < this.restrictions.cols

        return rowIsCorrect && colIsCorrect
    }

    fun getSnapshot(): List<Array<Color>> {
        return this.board.copyOf().toList()
    }

    fun isConnect4(): Boolean {
        return Coordinate.Direction
            .values()
            .map { direction -> this.lastMove.getNeighbors(this.restrictions.movesToWing, direction) }
            .filter { coordinates -> coordinates.all(this::isWithinBounds) }
            .map { coordinates -> coordinates.map { this.board[it.row][it.col] } }
            .any { colors -> colors.toSet().size == 1 }
    }

    fun getRestrictions(): BoardRestrictions {
        return BoardRestrictions(this.restrictions.rows, this.restrictions.cols, this.restrictions.movesToWing)
    }
}