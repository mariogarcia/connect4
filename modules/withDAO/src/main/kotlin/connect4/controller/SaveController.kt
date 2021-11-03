package connect4.controller

import connect4.controller.dao.GameDAO
import connect4.model.Session

class SaveController(private val session: Session, private val gameDAO: GameDAO): Controller(session) {
    fun save() {
        gameDAO.saveBoard(session.getBoardColors())
    }
}