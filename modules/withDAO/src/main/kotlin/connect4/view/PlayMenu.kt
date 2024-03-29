package connect4.view

import connect4.controller.PlayController

class PlayMenu(playController: PlayController): Menu() {
    init {
        this.addCommand(ActionCommand(playController))
        this.addCommand(RedoCommand(playController))
        this.addCommand(UndoCommand(playController))
    }
}