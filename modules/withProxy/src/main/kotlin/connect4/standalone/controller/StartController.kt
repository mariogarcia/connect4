package connect4.standalone.controller

import connect4.common.model.Color
import connect4.standalone.model.Session
import connect4.common.controller.StartController as CommonStartController

class StartController(private val session: Session): CommonStartController(session) {
    override fun reset() {
        this.session.reset()
    }

    override fun getBoardColors(): List<Array<Color>> {
        return this.session.getBoardColors()
    }

    override fun nextState() {
        this.session.next()
    }
}