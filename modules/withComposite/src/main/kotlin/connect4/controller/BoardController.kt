package connect4.controller

import connect4.model.Color

abstract class BoardController(private val session: Session): Controller(session) {
    fun getBoardSnapshot(): List<Array<Color>> {
        return this.session.getBoardSnapshot()
    }
}