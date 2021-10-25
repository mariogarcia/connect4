package connect4.controller

import connect4.model.Session
import connect4.view.ViewFactory

class StartController(private val session: Session): Controller(session) {
    fun control() {
        this.session.reset()
        ViewFactory.createStartView().showBanner()
    }
}