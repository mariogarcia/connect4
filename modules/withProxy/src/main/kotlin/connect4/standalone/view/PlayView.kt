package connect4.standalone.view

import connect4.standalone.controller.PlayController

class PlayView {
    fun interact(controller: PlayController) {
        do {
            PlayMenu(controller).execute()
        } while (!controller.isConnect4())
        controller.nextState()
    }
}