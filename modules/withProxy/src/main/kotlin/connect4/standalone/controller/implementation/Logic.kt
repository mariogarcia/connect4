package connect4.standalone.controller.implementation

import connect4.common.model.StateValue
import connect4.standalone.controller.Logic as AbstractLogic

class Logic: AbstractLogic() {
    init {
        this.controllers.putAll(listOf(
            Pair(StateValue.START, StartController(session)),
            Pair(StateValue.PLAY, PlayController(session)),
            Pair(StateValue.RESUME, ResumeController(session))
        ))
    }
}