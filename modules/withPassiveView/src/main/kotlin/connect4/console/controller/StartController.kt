package connect4.console.controller

import connect4.common.model.Session
import connect4.common.view.ViewFactory

class StartController(private val session: Session, viewFactory: ViewFactory): Controller(session, viewFactory) {
    fun control() {
        this.session.reset()
        this.viewFactory.createStartView().showBanner()
    }
}