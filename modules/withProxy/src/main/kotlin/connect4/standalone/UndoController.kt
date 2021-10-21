package connect4.standalone

import connect4.common.controller.Controller

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