package connect4.view

import connect4.controller.ResumeController

class ResumeView {
    boolean resume(ResumeController resumeController) {
        boolean startAllOver = Console.instance.askBoolean(Messages.NEW_GAME_QUESTION.toString())

        if (startAllOver) {
            resumeController.reset()
        } else {
            Console.instance.writeLn(Messages.GOOD_BYE)
            resumeController.nextState()
        }

        return startAllOver
    }
}
