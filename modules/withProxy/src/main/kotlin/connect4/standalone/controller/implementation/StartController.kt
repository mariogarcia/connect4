package connect4.standalone.controller.implementation

import connect4.common.model.Color
import connect4.common.model.Session
import connect4.standalone.controller.StartController as AbstractStartController

class StartController(private val session: Session): AbstractStartController(session) {
    override fun reset() {
        this.session.reset()
    }

    override fun getBoardColors(): List<Array<Color>> {
        return this.session.getBoardColors()
    }
}