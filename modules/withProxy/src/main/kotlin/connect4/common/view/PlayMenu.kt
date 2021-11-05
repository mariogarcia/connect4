package connect4.common.view

import connect4.common.controller.PlayController

class PlayMenu(playController: PlayController, console: Console): Menu(console) {
    init {
        this.addCommand(ActionCommand(playController, console))
        this.addCommand(RedoCommand(playController, console))
        this.addCommand(UndoCommand(playController, console))
    }
}