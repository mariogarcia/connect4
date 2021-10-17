package connect4.controller.play

import connect4.controller.Controller
import connect4.model.Session

class UndoController(private val session: Session): Controller(session) {
    fun undo() {
        this.session.undo()
    }

    fun isUndoable(): Boolean {
        return this.session.isUndoable()
    }
}