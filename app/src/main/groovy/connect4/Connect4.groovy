package connect4

import connect4.model.Game
import connect4.view.GameView

class Connect4 {
    private Game game
    private GameView gameView

    Connect4() {
        this.game = new Game()
        this.gameView = new GameView(this.game)
    }

    void start() {
        do {
            this.gameView.start()
            this.gameView.play()
        } while (this.gameView.resume())

        this.gameView.goodbye()
    }

    static void main(String[] args) {
        new Connect4().start()
    }
}
