package connect4.common.view

import connect4.common.controller.StartController

class StartView {
    fun show(startController: StartController) {
        startController.reset()

        Console.clear()
        Console.writeLn(Messages.GREETINGS)
        Console.showTable(startController.getBoardColors())

        startController.nextState()
    }
}