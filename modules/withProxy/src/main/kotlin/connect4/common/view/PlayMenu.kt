package connect4.common.view

import connect4.common.controller.PlayController

class PlayMenu(playController: PlayController): Menu() {
    init {
        this.addCommand(ActionCommand(playController))
        this.addCommand(RedoCommand(playController))
        this.addCommand(UndoCommand(playController))
    }
}