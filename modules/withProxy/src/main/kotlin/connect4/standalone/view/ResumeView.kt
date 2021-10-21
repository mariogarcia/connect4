package connect4.standalone.view

import connect4.standalone.controller.ResumeController

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