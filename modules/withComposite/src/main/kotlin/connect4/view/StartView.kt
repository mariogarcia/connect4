package connect4.view

import connect4.controller.StartController

class StartView {
    fun show(startController: StartController) {
        startController.reset()

        Console.clear()
        Console.writeLn(Messages.GREETINGS)
        Console.showTable(startController.getBoardSnapshot())

        startController.nextState()
    }
}