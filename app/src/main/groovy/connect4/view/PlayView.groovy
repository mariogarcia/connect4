package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

class PlayView {
    private BoardView boardView

    PlayView() {
        this.boardView = new BoardView()
    }

    void interact(PlayController playController) {
        do {
            playController.playWithCoordinate(this.getCoordinateFromUser(playController))
            this.boardView.show(playController)
            playController.togglePlayer()
        } while (!playController.isConnect4())

        playController.nextState()
    }

    private Coordinate getCoordinateFromUser(PlayController playController) {
        String question = Messages.NEXT_MOVE_QUESTION.format(playController.currentColor)
        Coordinate coordinate

        do {
            coordinate = ConsoleRenderer.instance.askCoordinate(question)
        } while (!playController.isValidCoordinate(coordinate))

        return coordinate
    }
}
