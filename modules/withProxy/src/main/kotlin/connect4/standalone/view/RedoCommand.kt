package connect4.standalone.view

import connect4.standalone.controller.PlayController

class RedoCommand(controller: PlayController): Command(Messages.COMMAND_REDO.toString(), controller) {
    override fun isActive(): Boolean = this.controller.isRedoable()
    override fun execute() {
        this.controller.redo()
        this.showBoard()
    }
}