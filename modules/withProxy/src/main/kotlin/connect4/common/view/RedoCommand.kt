package connect4.common.view

import connect4.common.controller.PlayController

class RedoCommand(controller: PlayController): Command(Messages.COMMAND_REDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isRedoable()
    override fun execute(console: Console) {
        this.controller.redo()
        console.showTable(controller.getBoardSnapshot())
    }
}