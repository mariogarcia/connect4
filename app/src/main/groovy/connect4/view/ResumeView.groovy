package connect4.view

import connect4.controller.ResumeController

class ResumeView {
    boolean resume(ResumeController resumeController) {
        boolean startAllOver = ConsoleRenderer.instance.askBoolean(Messages.NEW_GAME_QUESTION.toString())

        if (startAllOver) {
            resumeController.reset()
        } else {
            resumeController.nextState()
        }

        return startAllOver
    }
}
