package connect4.controller

import connect4.model.Session

abstract class Controller(private val session: Session) {
    fun nextState() {
        this.session.next()
    }
}