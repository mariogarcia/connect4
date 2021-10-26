package connect4.console.view

import connect4.common.model.Color

class BoardView {
    fun showBoard(boardColors: List<Array<Color>>) {
        Console.showTable(boardColors)
    }
}