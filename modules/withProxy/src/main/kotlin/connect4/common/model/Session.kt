package connect4.common.model

interface Session {
    fun getStateValue(): StateValue
    fun next()
    fun getBoardColors(): List<Array<Color>>
    fun reset()
    fun playWithCoordinate(coordinate: Coordinate)
    fun isConnect4(): Boolean
    fun isValidCoordinate(coordinate: Coordinate): Boolean
    fun getCurrentPlayer(): Player
    fun redo()
    fun isRedoable(): Boolean
    fun undo()
    fun isUndoable(): Boolean
}
