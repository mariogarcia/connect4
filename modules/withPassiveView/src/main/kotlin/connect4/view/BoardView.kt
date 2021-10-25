package connect4.view

import connect4.model.Color

class BoardView {
    fun showBoard(boardColors: List<Array<Color>>) {
        Console.showTable(boardColors)
    }
}