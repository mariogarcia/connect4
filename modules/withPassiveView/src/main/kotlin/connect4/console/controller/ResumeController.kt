package connect4.console.controller

import connect4.common.model.Session
import connect4.common.view.ViewFactory

class ResumeController(session: Session, viewFactory: ViewFactory): Controller(session, viewFactory) {
    fun control(): Boolean = viewFactory.createResumeView().resume()
}