package connect4.common.view

import connect4.common.controller.StartController

class StartView {
    fun show(startController: StartController, console: Console) {
        startController.reset()

        with(console) {
            clear()
            writeLn(Messages.GREETINGS)
            showTable(startController.getBoardColors())
        }

        startController.nextState()
    }
}