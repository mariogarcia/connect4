package connect4.common.view

import connect4.common.controller.ResumeController

class ResumeView {
    fun resume(controller: ResumeController): Boolean {
        val startAllOver = Console.askBoolean(Messages.NEW_GAME_QUESTION.toString())

        if (startAllOver) {
            controller.reset()
        } else {
            Console.writeLn(Messages.GOOD_BYE)
            controller.nextState()
        }

        return startAllOver
    }
}