package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate
import connect4.model.Player

class PlayView {

    void interact(PlayController playController) {
        do {
            Player player = playController.currentPlayer
            PlayInputView inputView = PlayInputViewFactory.instance.getViewByPlayer(player)
            Coordinate coordinate = inputView.getCoordinate(playController)

            playController.playWithCoordinate(coordinate)

            Console.instance.clear()
            Console.instance.showTable(playController.boardSnapshot)

            playController.togglePlayer()
        } while (!playController.isConnect4())

        playController.nextState()
    }
}
