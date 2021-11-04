package connect4.common.test

import connect4.common.model.*
import org.junit.jupiter.params.converter.TypedArgumentConverter

class Connect4BoardSourceConverter: TypedArgumentConverter<String, Board>(String::class.java, Board::class.java) {
    override fun convert(source: String?): Board {
        val board = Board()
        val rows = source
            ?.split("\n")
            ?.map { it.split(",").map(String::trim) }
            ?.filter { it.size > 1 }

        rows?.forEachIndexed { i, row ->
            row.forEachIndexed { j, value ->
                board.fillCell(Coordinate(i, j), HumanPlayer(resolveColor(value)))
            }
        }

        return board
    }

    private fun resolveColor(symbol: String): Color = when(symbol) {
        "R" -> Color.RED
        "B" -> Color.BLUE
        else -> Color.NULL
    }
}