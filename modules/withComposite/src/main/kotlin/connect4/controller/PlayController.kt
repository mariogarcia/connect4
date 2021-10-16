package connect4.controller

import connect4.model.*

class PlayController(private val game: Game, private val state: State): BoardController(game, state) {
    fun playWithCoordinate(coordinate: Coordinate) {
        this.game.playWithCoordinate(coordinate)
    }

    fun togglePlayer() {
        this.game.togglePlayer()
    }

    fun isConnect4(): Boolean {
        return this.game.isConnect4()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.game.isValidCoordinate(coordinate)
    }

    fun getRandomCoordinate(): Coordinate {
        val coordinates: MutableList<Coordinate> = mutableListOf()

        this.getBoardSnapshot().forEachIndexed { rowIndex: Int, row: Array<Color> ->
            row.forEachIndexed { columnIndex: Int, entry: Color ->
                if (entry.isNull()) {
                    coordinates.add(Coordinate(rowIndex, columnIndex))
                }
            }
        }

        return coordinates.shuffled().first()
    }

    fun getCurrentPlayer(): Player {
        return this.game.getCurrentPlayer()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}