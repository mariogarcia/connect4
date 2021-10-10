package connect4.view

import connect4.model.Color
import groovy.transform.InheritConstructors

@InheritConstructors
class BoardView extends ConsoleView {
    void show() {
        this.showSeparator()
        this.game.boardSnapshot.each(this::showRow)
        this.showSeparator()
    }

    private void showRow(Color[] row) {
        this.renderer.show(row.collect { color -> "$color\t" })
    }

    private void showSeparator() {
        this.renderer.show("=================================================")
    }
}
