package connect4.standalone.view

import connect4.standalone.controller.StartController

class StartView {
    fun show(startController: StartController) {
        startController.reset()

        Console.clear()
        Console.writeLn(Messages.GREETINGS)
        Console.showTable(startController.getBoardColors())

        startController.nextState()
    }
}