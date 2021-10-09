package connect4.view

import connect4.model.Color
import connect4.model.Game

class BoardView extends ConsoleView {
    BoardView(Game game) {
        super(game)
    }

    void interact() {
        this.renderer.writeln("=================================================")
        this.game.boardSnapshot.each {
            this.renderer.writeln(it.collect { "$it\t"})
        }
        this.renderer.writeln("=================================================")

        this.renderer.writeln("")
    }
}
