package connect4.controller

import connect4.controller.play.ActionController
import connect4.controller.play.RedoController
import connect4.controller.play.UndoController
import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.Player

class PlayController(private val session: Session): Controller(session), VisitorAwareController {
    private val actionController = ActionController(session)
    private val redoController = RedoController(session)
    private val undoController = UndoController(session)

    fun playWithCoordinate(coordinate: Coordinate) {
        this.actionController.playWithCoordinate(coordinate)
    }

    fun togglePlayer() {
        this.actionController.togglePlayer()
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
        return this.session.getBoardSnapshot()
    }
}