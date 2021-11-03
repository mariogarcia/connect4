package connect4.controller.dao

import connect4.model.Color

interface GameDAO {
    fun saveBoard(boardColors: List<Array<Color>>)
}