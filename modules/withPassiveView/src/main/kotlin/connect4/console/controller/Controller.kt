package connect4.console.controller

import connect4.common.model.Session
import connect4.common.view.ViewFactory

abstract class Controller(private val session: Session, protected val viewFactory: ViewFactory) {
    fun showBoard() {
        viewFactory.createBoardView().showBoard(this.session.getBoardColors())
    }
}