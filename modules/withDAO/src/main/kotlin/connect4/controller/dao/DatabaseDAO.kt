package connect4.controller.dao

import connect4.model.Color

class DatabaseDAO: GameDAO {
    override fun saveBoard(boardColors: List<Array<Color>>) {
        println("====================> BOARD STORED IN DATABASE")
    }
}