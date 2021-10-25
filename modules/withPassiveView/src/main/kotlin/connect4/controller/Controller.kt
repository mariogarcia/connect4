package connect4.controller

import connect4.model.Session
import connect4.view.ViewFactory

abstract class Controller(private val session: Session) {
    fun showBoard() {
        ViewFactory.createBoardView().showBoard(this.session.getBoardColors())
    }
}