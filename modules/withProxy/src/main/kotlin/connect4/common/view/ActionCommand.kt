package connect4.common.view

import connect4.common.controller.PlayController

class ActionCommand(controller: PlayController): Command(Messages.COMMAND_ACTION.toString(), controller) {
    override fun isActive(): Boolean = true

    override fun execute(console: Console) {
        val player = this.controller.getCurrentPlayer()
        val inputView = PlayInputViewFactory.getViewByPlayer(player)
        val coordinate = inputView.getCoordinate(this.controller, console)

        this.controller.playWithCoordinate(coordinate)
        console.showTable(this.controller.getBoardSnapshot())
    }
}