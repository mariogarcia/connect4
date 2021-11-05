package connect4.common.view

import connect4.common.controller.StartController

class StartView(private val console: Console) {
    fun show(startController: StartController) {
        startController.reset()

        with(console) {
            clear()
            writeLn(Messages.GREETINGS)
            showTable(startController.getBoardColors())
        }

        startController.nextState()
    }
}