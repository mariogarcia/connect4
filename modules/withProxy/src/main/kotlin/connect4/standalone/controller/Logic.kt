package connect4.standalone.controller

import connect4.common.controller.PlayController
import connect4.common.controller.ResumeController
import connect4.common.controller.StartController
import connect4.common.model.StateValue
import connect4.standalone.model.Session
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