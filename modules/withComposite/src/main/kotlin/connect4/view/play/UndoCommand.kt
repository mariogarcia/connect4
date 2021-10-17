package connect4.view.play

import connect4.controller.PlayController
import connect4.view.Messages

class UndoCommand(controller: PlayController): Command(Messages.COMMAND_UNDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isUndoable()
    override fun execute() {
        this.controller.undo()
        this.showBoard()
    }
}