package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.controller.ResumeController
import connect4.common.controller.StartController

class GameView: View {
    private val console = ConsoleFactory.getConsoleInstance()
    private val startView = StartView(console)
    private val resumeView = ResumeView(console)
    private val playView = PlayView(console)

    override fun visit(startController: StartController) {
        startView.show(startController)
    }

    override fun visit(playController: PlayController) {
        playView.interact(playController)
    }

    override fun visit(resumeController: ResumeController): Boolean {
        return resumeView.resume(resumeController)
    }
}