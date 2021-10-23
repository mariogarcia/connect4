package connect4.standalone.controller

import connect4.standalone.model.Session
import connect4.common.controller.ResumeController as CommonResumeController

class ResumeController(private val session: Session): CommonResumeController(session) {
    override fun reset() {
        this.session.reset()
    }

    override fun nextState() {
        this.session.next()
    }
}