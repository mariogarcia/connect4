package connect4.view

import connect4.i18n.Messages
import connect4.model.Coordinate
import connect4.model.Game
import connect4.model.Player

class PlayView extends ConsoleView {
    BoardView boardView
    PlayView(Game game) {
        super(game)
        this.boardView = new BoardView(game)
    }

    void interact() {
        do {
            Coordinate nextMove = this.askForCoordinate(this.game.currentPlayer)

            this.game.playWithCoordinate(nextMove)
            this.boardView.interact()
            this.game.togglePlayer()
        } while (!this.game.isConnect4())
    }

    private Coordinate askForCoordinate(Player player) {
        Coordinate coordinate
        boolean  isValidCoordinate
        String question = Messages.NEXT_MOVE_QUESTION.format(player.color.toString())

        do {
            coordinate = this.renderer.ask(question, new CoordinateMapper())
            isValidCoordinate = this.game.isValidCoordinate(coordinate)
        } while (!isValidCoordinate)

        return coordinate
    }
}
