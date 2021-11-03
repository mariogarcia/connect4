package connect4.view

import connect4.controller.PlayController

class SaveCommand(controller: PlayController): Command(Messages.COMMAND_SAVE.toString(), controller) {
    override fun isActive() = true
    override fun execute() = this.controller.save()
}