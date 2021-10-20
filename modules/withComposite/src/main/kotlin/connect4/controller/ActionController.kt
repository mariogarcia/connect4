package connect4.controller

import connect4.model.Session
import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.Player

class ActionController(private val session: Session): Controller(session) {
    fun playWithCoordinate(coordinate: Coordinate) {
        this.session.playWithCoordinate(coordinate)
    }

    fun isConnect4(): Boolean {
        return this.session.isConnect4()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.session.isValidCoordinate(coordinate)
    }

    fun getRandomCoordinate(): Coordinate {
        val coordinates: MutableList<Coordinate> = mutableListOf()

        this.session.getBoardColors().forEachIndexed { rowIndex: Int, row: Array<Color> ->
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

    fun getBoardColors(): List<Array<Color>> {
        return this.session.getBoardColors()
    }
}