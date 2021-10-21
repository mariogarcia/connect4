package connect4.standalone

import connect4.common.controller.Controller

class RedoController(private val session: Session): Controller(session) {
    fun redo() {
        this.session.redo()
    }

    fun isRedoable(): Boolean {
        return this.session.isRedoable()
    }

    override fun nextState() {
        this.session.next()
    }
}