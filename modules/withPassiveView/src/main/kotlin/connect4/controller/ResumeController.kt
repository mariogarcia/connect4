package connect4.controller

import connect4.model.Session
import connect4.view.ViewFactory

class ResumeController(session: Session): Controller(session) {
    fun control(): Boolean {
        return ViewFactory.createResumeView().resume()
    }
}