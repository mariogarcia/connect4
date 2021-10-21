package connect4.standalone

import connect4.common.controller.Controller
import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player

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
                if (entry == Color.NULL) {
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

    override fun nextState() {
        this.session.next()
    }
}