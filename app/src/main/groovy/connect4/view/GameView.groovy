package connect4.view

import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController

class GameView implements View {
    private StartView startView
    private PlayView playView
    private ResumeView resumeView

    GameView() {
        this.startView = new StartView()
        this.playView = new PlayView()
        this.resumeView = new ResumeView()
    }

    @Override
    void start(StartController startController) {
        this.startView.show(startController)
    }

    @Override
    void play(PlayController playController) {
        this.playView.interact(playController)
    }

    @Override
    boolean resume(ResumeController resumeController) {
        return this.resumeView.resume(resumeController)
    }
}
