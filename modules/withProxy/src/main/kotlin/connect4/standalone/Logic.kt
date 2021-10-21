package connect4.standalone

import connect4.common.model.StateValue
import connect4.common.controller.Logic as CommonLogic

class Logic(session: Session): CommonLogic(session) {
    init {
        this.controllers.putAll(listOf(
            Pair(StateValue.START, StartController(session)),
            Pair(StateValue.PLAY, PlayController(session)),
            Pair(StateValue.RESUME, ResumeController(session))
        ))
    }
}