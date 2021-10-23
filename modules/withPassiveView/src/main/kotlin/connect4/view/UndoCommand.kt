package connect4.view

import connect4.controller.PlayController

class UndoCommand(controller: PlayController): Command(Messages.COMMAND_UNDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isUndoable()
    override fun execute() {
        this.controller.undo()
        this.showBoard()
    }
}