package connect4.common.view

import connect4.common.controller.ResumeController

class ResumeView {
    fun resume(controller: ResumeController, console: Console): Boolean {
        val startAllOver = console.askBoolean(Messages.NEW_GAME_QUESTION.toString())

        if (startAllOver) {
            controller.reset()
        } else {
            console.writeLn(Messages.GOOD_BYE)
            controller.nextState()
        }

        return startAllOver
    }
}