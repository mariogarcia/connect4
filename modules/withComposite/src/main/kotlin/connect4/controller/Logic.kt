package connect4.controller

import connect4.model.StateValue

class Logic {
    private val session = Session()
    private val controllers: Map<StateValue, Controller> = mapOf(
        Pair(StateValue.START, StartController(session)),
        Pair(StateValue.PLAY, PlayController(session)),
        Pair(StateValue.RESUME, ResumeController(session))
    )

    fun getController(): Controller? {
        return this.controllers[this.session.getStateValue()]
    }
}