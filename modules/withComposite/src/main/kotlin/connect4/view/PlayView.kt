package connect4.view

import connect4.controller.PlayController

class PlayView {
    fun interact(controller: PlayController) {
        do {
            PlayMenu(controller).execute()
        } while (!controller.isConnect4())
        controller.nextState()
    }
}