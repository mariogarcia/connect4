package connect4.view

import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController

class GameView implements View {
    private StartView startView = new StartView()
    private ResumeView resumeView = new ResumeView()
    private PlayView playView = new PlayView()

    @Override
    void visit(StartController startController) {
        this.startView.show(startController)
    }

    @Override
    void visit(PlayController playController) {
        playView.interact(playController)
    }

    @Override
    boolean visit(ResumeController resumeController) {
        return this.resumeView.resume(resumeController)
    }
}
