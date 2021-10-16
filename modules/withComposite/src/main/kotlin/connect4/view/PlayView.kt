package connect4.view

import connect4.controller.PlayController

class PlayView {
    fun interact(controller: PlayController) {
        do {
            val player = controller.getCurrentPlayer()
            val inputView = PlayInputViewFactory.getViewByPlayer(player)
            val coordinate = inputView.getCoordinate(controller)

            controller.playWithCoordinate(coordinate)

            Console.clear()
            Console.showTable(controller.getBoardSnapshot())
            controller.togglePlayer()

        } while(!controller.isConnect4())
        controller.nextState()
    }
}