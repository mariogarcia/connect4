package connect4.view

import connect4.controller.PlayController
import connect4.view.play.PlayMenu

class PlayView {
    fun interact(controller: PlayController) {
        do {
            PlayMenu(controller).execute()
        } while (!controller.isConnect4())
        controller.nextState()
    }
}