package connect4.controller.dao

import connect4.model.Color

class EmailDAO: GameDAO {
    override fun saveBoard(boardColors: List<Array<Color>>) {
        println("=======================> BOARD SENT IN AN EMAIL")
    }
}