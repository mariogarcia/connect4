package connect4.controller

import connect4.controller.dao.DatabaseDAO
import connect4.model.Session
import connect4.model.StateValue

class Logic {
    private val session = Session()
    private val controllers: Map<StateValue, VisitorAwareController> = mapOf(
        Pair(StateValue.START, StartController(session)),
        Pair(StateValue.PLAY, PlayController(session, DatabaseDAO())),
        Pair(StateValue.RESUME, ResumeController(session))
    )

    fun getController(): VisitorAwareController? {
        return this.controllers[this.session.getStateValue()]
    }
}