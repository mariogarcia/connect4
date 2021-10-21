package connect4.standalone.view

import connect4.standalone.controller.PlayController

class PlayMenu(playController: PlayController): Menu() {
    init {
        this.addCommand(ActionCommand(playController))
        this.addCommand(RedoCommand(playController))
        this.addCommand(UndoCommand(playController))
    }
}