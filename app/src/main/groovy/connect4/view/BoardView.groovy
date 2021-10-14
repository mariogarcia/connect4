package connect4.view

import connect4.controller.ControllerWithBoardSnapshot
import connect4.model.Color

class BoardView  {
    void show(ControllerWithBoardSnapshot controller) {
        this.showSeparator()
        controller.boardSnapshot.each(this::showRow)
        this.showSeparator()
    }

    private void showRow(Color[] row) {
        Console.instance.show(row.collect { color -> "$color\t" })
    }

    private void showSeparator() {
        Console.instance.show("=================================================")
    }
}
