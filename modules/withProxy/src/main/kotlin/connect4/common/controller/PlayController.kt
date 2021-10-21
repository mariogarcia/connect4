package connect4.common.controller

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player
import connect4.common.model.Session

abstract class PlayController(session: Session): Controller(session), VisitorAwareController {

    abstract fun playWithCoordinate(coordinate: Coordinate)
    abstract fun isConnect4(): Boolean
    abstract fun isValidCoordinate(coordinate: Coordinate): Boolean
    abstract fun getRandomCoordinate(): Coordinate
    abstract fun getCurrentPlayer(): Player
    abstract fun getBoardSnapshot(): List<Array<Color>>
    abstract fun redo()
    abstract fun isRedoable(): Boolean
    abstract fun undo()
    abstract fun isUndoable(): Boolean

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}