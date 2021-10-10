package connect4.view

import connect4.controller.Controller
import connect4.model.Color

class BoardView  {
    void show(Controller controller) {
        this.showSeparator()
        controller.boardSnapshot.each(this::showRow)
        this.showSeparator()
    }

    private void showRow(Color[] row) {
        ConsoleRenderer.instance.show(row.collect { color -> "$color\t" })
    }

    private void showSeparator() {
        ConsoleRenderer.instance.show("=================================================")
    }
}
