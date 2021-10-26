package connect4.common.model

open class Coordinate(val row: Int, val col: Int) {
    enum class Direction(val alpha: Int, val beta: Int) {
        HORIZONTAL_LEFT(0, 1),
        HORIZONTAL_RIGHT(0, -1),
        VERTICAL_UP(-1, 0),
        VERTICAL_DOWN(1, 0),
        DIAGONAL_MAIN_UP(-1, -1),
        DIAGONAL_MAIN_DOWN(1, 1),
        DIAGONAL_INVERTED_UP(-1, 1),
        DIAGONAL_INVERTED_DOWN(1, -1)
    }

    open fun getNeighbors(howMany: Int, direction: Direction): List<Coordinate> {
        return (0 until howMany).map { applyDelta(it, direction) }
    }

    private fun applyDelta(index: Int, direction: Direction): Coordinate {
        return Coordinate(this.row + (index * direction.alpha), this.col + (index * direction.beta))
    }

    override fun equals(other: Any?): Boolean {
        return (other is Coordinate) && row == other.row && col == other.col
    }

    override fun hashCode(): Int = this.toString().hashCode()

    override fun toString(): String = "coordinate(row(${row}), col(${col}))"
}