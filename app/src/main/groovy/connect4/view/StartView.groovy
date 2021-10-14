package connect4.view

import connect4.controller.StartController

class StartView  {
    void show(StartController startController) {
        startController.reset()

        Console.instance.clear()
        Console.instance.writeLn(Messages.GREETINGS)
        Console.instance.showTable(startController.boardSnapshot)

        startController.nextState()
    }
}
