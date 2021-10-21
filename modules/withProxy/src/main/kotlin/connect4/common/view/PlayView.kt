package connect4.common.view

import connect4.common.controller.PlayController

class PlayView {
    fun interact(controller: PlayController) {
        do {
            PlayMenu(controller).execute()
        } while (!controller.isConnect4())
        controller.nextState()
    }
}