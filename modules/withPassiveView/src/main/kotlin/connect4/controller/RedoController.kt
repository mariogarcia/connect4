package connect4.controller

import connect4.controller.Controller
import connect4.model.Session

class RedoController(private val session: Session): Controller(session) {
    fun redo() {
        this.session.redo()
    }

    fun isRedoable(): Boolean {
        return this.session.isRedoable()
    }
}