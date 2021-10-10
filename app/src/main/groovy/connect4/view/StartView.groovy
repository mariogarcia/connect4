package connect4.view

import connect4.model.Game

class StartView extends ConsoleView {
    BoardView boardView
    GreetingsView greetingsView

    StartView(Game game) {
        super(game)
        this.boardView = new BoardView(this.game)
        this.greetingsView = new GreetingsView(this.game)
    }

    void show() {
        this.game.reset()
        this.greetingsView.interact()
        this.boardView.show()
    }
}
