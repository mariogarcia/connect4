package connect4.view.play

import connect4.controller.PlayController
import connect4.view.Messages

class RedoCommand(controller: PlayController): Command(Messages.COMMAND_REDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isRedoable()
    override fun execute() {
        this.controller.redo()
        this.showBoard()
    }
}