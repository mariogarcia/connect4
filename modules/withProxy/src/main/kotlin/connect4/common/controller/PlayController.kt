package connect4.common.controller

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player
import connect4.common.model.Session

class PlayController(session: Session): Controller(session), VisitorAwareController {
    private val actionController = ActionController(session)
    private val redoController = RedoController(session)
    private val undoController = UndoController(session)

    fun playWithCoordinate(coordinate: Coordinate) {
        this.actionController.playWithCoordinate(coordinate)
    }

    fun isConnect4(): Boolean {
        return this.actionController.isConnect4()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.actionController.isValidCoordinate(coordinate)
    }

    fun getRandomCoordinate(): Coordinate {
        return this.actionController.getRandomCoordinate()
    }

    fun getCurrentPlayer(): Player {
        return this.actionController.getCurrentPlayer()
    }

    fun getBoardSnapshot(): List<Array<Color>> {
        return this.actionController.getBoardColors()
    }

    fun redo() {
        this.redoController.redo()
    }

    fun isRedoable(): Boolean {
        return this.redoController.isRedoable()
    }

    fun undo() {
        return this.undoController.undo()
    }

    fun isUndoable(): Boolean {
        return this.undoController.isUndoable()
    }

    override fun nextState() {
        this.actionController.nextState()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}