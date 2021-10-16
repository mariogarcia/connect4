package connect4.controller.play

import connect4.controller.Controller
import connect4.controller.Session
import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.Player

class ActionController(private val session: Session): Controller(session) {
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

        this.session.getBoardSnapshot().forEachIndexed { rowIndex: Int, row: Array<Color> ->
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
}