package connect4.common.controller

import connect4.common.controller.Controller
import connect4.common.model.Session

class UndoController(private val session: Session): Controller(session) {
    fun undo() {
        this.session.undo()
    }

    fun isUndoable(): Boolean {
        return this.session.isUndoable()
    }

    override fun nextState() {
        this.session.next()
    }
}