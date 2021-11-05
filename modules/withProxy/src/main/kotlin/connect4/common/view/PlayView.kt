package connect4.common.view

import connect4.common.controller.PlayController

class PlayView {
    fun interact(controller: PlayController, console: Console) {
        do {
            PlayMenu(controller).execute(console)
        } while (!controller.isConnect4())
        controller.nextState()
    }
}