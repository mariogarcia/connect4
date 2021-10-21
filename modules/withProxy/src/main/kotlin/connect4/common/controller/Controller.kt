package connect4.common.controller

import connect4.common.model.Session

abstract class Controller(private val session: Session) {
    abstract fun nextState()
}