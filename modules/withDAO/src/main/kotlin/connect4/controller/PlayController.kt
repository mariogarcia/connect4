package connect4.controller

import connect4.controller.dao.GameDAO
import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.Player
import connect4.model.Session

class PlayController(session: Session, gameDAO: GameDAO): Controller(session), VisitorAwareController {
    private val actionController = ActionController(session)
    private val redoController = RedoController(session)
    private val undoController = UndoController(session)
    private val saveController = SaveController(session, gameDAO)

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

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
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

    fun save() {
        this.saveController.save()
    }
}