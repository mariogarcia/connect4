package connect4.model

class Board(private val restrictions: BoardRestrictions) {
    private val cells: MutableMap<Coordinate, Player> = mutableMapOf()
    private var lastMove: Coordinate = NullCoordinate()

    init {
        this.reset()
    }

    fun reset() {
        (0 until restrictions.rows).forEach { i ->
            (0 until restrictions.cols).forEach { j ->
                cells[Coordinate(i, j)] = NullPlayer()
            }
        }
    }

    fun copy(): Board {
        val boardCopy = Board(this.restrictions)
        this.cells.forEach(boardCopy::fillCell)
        return boardCopy
    }

    fun getBoardColors(): List<Array<Color>> {
        val colors: Array<Array<Color>> = Array(restrictions.rows) {
            Array(restrictions.cols) {
                Color.NULL
            }
        }

        this.cells.entries.forEach {
            colors[it.key.row][it.key.col] = it.value.color
        }

        return colors.toList()
    }

    fun fillCell(coordinate: Coordinate, player: Player) {
        this.lastMove = coordinate
        this.cells[coordinate] = player
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.isEmptyAt(coordinate) && this.isWithinBounds(coordinate)
    }

    private fun isEmptyAt(coordinate: Coordinate): Boolean {
        return this.cells[coordinate]?.color == Color.NULL
    }

    private fun isWithinBounds(coordinate: Coordinate): Boolean {
        val rowIsCorrect = coordinate.row >= 0 && coordinate.row < this.restrictions.rows
        val colIsCorrect = coordinate.col >= 0 && coordinate.col < this.restrictions.cols

        return rowIsCorrect && colIsCorrect
    }

    fun isConnect4(): Boolean {
        return Coordinate.Direction
            .values()
            .map { direction -> this.lastMove.getNeighbors(this.restrictions.movesToWing, direction) }
            .filter { coordinates -> coordinates.all(this::isWithinBounds) }
            .map { coordinates -> coordinates.map { this.cells[it] } }
            .any { colors -> colors.toSet().size == 1 }
    }
}