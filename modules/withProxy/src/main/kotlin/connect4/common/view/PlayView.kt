package connect4.common.view

import connect4.common.controller.PlayController

class PlayView(private val console: Console) {
    fun interact(controller: PlayController) {
        do {
            PlayMenu(controller, console).execute()
        } while (!controller.isConnect4())
        controller.nextState()
    }
}