package connect4.common.model

class Board(private val rows: Int, private val cols: Int, private val winningMoves: Int) {
    private val cells: MutableMap<Coordinate, Player> = mutableMapOf()
    private var lastMove: Coordinate = NullCoordinate()

    init {
        this.reset()
    }

    fun reset() {
        (0 until rows).forEach { i ->
            (0 until cols).forEach { j ->
                cells[Coordinate(i, j)] = Player(Color.NULL)
            }
        }
    }

    fun getBoardColors(): List<Array<Color>> {
        val colors: Array<Array<Color>> = Array(rows) {
            Array(cols) {
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
        val rowIsCorrect = coordinate.row >= 0 && coordinate.row < this.rows
        val colIsCorrect = coordinate.col >= 0 && coordinate.col < this.cols

        return rowIsCorrect && colIsCorrect
    }

    fun isConnect4(): Boolean {
        return Coordinate.Direction
            .values()
            .map { direction -> this.lastMove.getNeighbors(this.winningMoves, direction) }
            .filter { coordinates -> coordinates.all(this::isWithinBounds) }
            .map { coordinates -> coordinates.map { this.cells[it] } }
            .any { colors -> colors.toSet().size == 1 }
    }
}