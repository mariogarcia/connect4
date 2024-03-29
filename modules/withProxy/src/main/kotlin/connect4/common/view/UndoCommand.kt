package connect4.common.view

import connect4.common.controller.PlayController

class UndoCommand(controller: PlayController): Command(Messages.COMMAND_UNDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isUndoable()
    override fun execute(console: Console) {
        this.controller.undo()
        console.showTable(controller.getBoardSnapshot())
    }
}