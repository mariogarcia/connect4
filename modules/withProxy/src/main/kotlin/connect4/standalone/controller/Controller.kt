package connect4.standalone.controller

import connect4.common.model.Session

abstract class Controller(private val session: Session) {
    fun nextState() {
        this.session.next()
    }
}