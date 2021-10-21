package connect4.standalone.controller.implementation

import connect4.common.model.Session
import connect4.standalone.controller.ResumeController as AbstractResumeController

class ResumeController(private val session: Session): AbstractResumeController(session) {
    override fun reset() {
        this.session.reset()
    }
}