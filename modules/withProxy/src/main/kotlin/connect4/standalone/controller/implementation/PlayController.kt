package connect4.standalone.controller.implementation

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player
import connect4.common.model.Session
import connect4.standalone.controller.ActionController
import connect4.standalone.controller.PlayController as AbstractPlayController
import connect4.standalone.controller.RedoController
import connect4.standalone.controller.UndoController

class PlayController(session: Session): AbstractPlayController(session) {
    private val actionController = ActionController(session)
    private val redoController = RedoController(session)
    private val undoController = UndoController(session)

    override fun playWithCoordinate(coordinate: Coordinate) {
        this.actionController.playWithCoordinate(coordinate)
    }

    override fun isConnect4(): Boolean {
        return this.actionController.isConnect4()
    }

    override fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.actionController.isValidCoordinate(coordinate)
    }

    override fun getRandomCoordinate(): Coordinate {
        return this.actionController.getRandomCoordinate()
    }

    override fun getCurrentPlayer(): Player {
        return this.actionController.getCurrentPlayer()
    }

    override fun getBoardSnapshot(): List<Array<Color>> {
        return this.actionController.getBoardColors()
    }

    override fun redo() {
        this.redoController.redo()
    }

    override fun isRedoable(): Boolean {
        return this.redoController.isRedoable()
    }

    override fun undo() {
        return this.undoController.undo()
    }

    override fun isUndoable(): Boolean {
        return this.undoController.isUndoable()
    }
}