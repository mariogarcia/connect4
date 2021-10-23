package connect4.standalone.controller

import connect4.common.controller.Controller
import connect4.standalone.model.Session

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