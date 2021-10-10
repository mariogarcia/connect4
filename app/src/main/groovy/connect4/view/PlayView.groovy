package connect4.view

import connect4.i18n.Messages
import connect4.model.Coordinate
import connect4.model.Game

class PlayView extends ConsoleView {
    private BoardView boardView

    PlayView(Game game) {
        super(game)
        this.boardView = new BoardView(game)
    }

    void interact() {
        do {
            this.game.playWithCoordinate(this.coordinateFromUser)
            this.boardView.show()
            this.game.togglePlayer()
        } while (!this.game.isConnect4())
    }

    private Coordinate getCoordinateFromUser() {
        String question = Messages.NEXT_MOVE_QUESTION.format(this.game.currentColor)
        Coordinate coordinate

        do {
            coordinate = this.renderer.ask(question, new CoordinateMapper())
        } while (!this.game.isValidCoordinate(coordinate))

        return coordinate
    }
}
