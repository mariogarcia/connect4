package connect4.controller

import connect4.model.*

class PlayController(private val session: Session): BoardController(session) {
    fun playWithCoordinate(coordinate: Coordinate) {
        this.session.playWithCoordinate(coordinate)
    }

    fun togglePlayer() {
        this.session.togglePlayer()
    }

    fun isConnect4(): Boolean {
        return this.session.isConnect4()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.session.isValidCoordinate(coordinate)
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
        return this.session.getCurrentPlayer()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}