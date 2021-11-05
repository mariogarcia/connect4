package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.controller.ResumeController
import connect4.common.controller.StartController

class GameView: View {
    private val console = ConsoleFactory.getConsoleInstance()
    private val startView = StartView()
    private val resumeView = ResumeView()
    private val playView = PlayView()

    override fun visit(startController: StartController) {
        startView.show(startController, console)
    }

    override fun visit(playController: PlayController) {
        playView.interact(playController, console)
    }

    override fun visit(resumeController: ResumeController): Boolean {
        return resumeView.resume(resumeController, console)
    }
}