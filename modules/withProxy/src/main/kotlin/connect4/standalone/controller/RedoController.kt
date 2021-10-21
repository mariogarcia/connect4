package connect4.standalone.controller

import connect4.common.model.Session

class RedoController(private val session: Session): Controller(session) {
    fun redo() {
        this.session.redo()
    }

    fun isRedoable(): Boolean {
        return this.session.isRedoable()
    }
}