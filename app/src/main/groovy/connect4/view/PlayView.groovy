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
            PlayInputView inputView = PlayInputViewFactory.instance.getByPlayer(playController.currentPlayer)
            Coordinate coordinate = inputView.getCoordinate(playController)

            playController.playWithCoordinate(coordinate)
            this.boardView.show(playController)
            playController.togglePlayer()
        } while (!playController.isConnect4())

        playController.nextState()
    }
}
