package connect4.common.view

import connect4.common.model.Color
import connect4.common.model.Coordinate

interface Console {
    fun write(message: String)
    fun writeLn(message: Any)
    fun writeAndWait(message: String, seconds: Long)
    fun writeLnAndWait(message: String, seconds: Long)
    fun clear()
    fun showTable(cells: List<Array<Color>>)
    fun askBoolean(message: String): Boolean
    fun askInt(message: String): Int
    fun askCoordinate(message: String): Coordinate
}