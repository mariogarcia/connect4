package connect4.view

import connect4.controller.GoodbyeController
import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController

class GameView implements View {
    private StartView startView
    private PlayView playView
    private ResumeView resumeView
    private GoodbyeView goodbyeView

    GameView() {
        this.startView = new StartView()
        this.playView = new PlayView()
        this.resumeView = new ResumeView()
        this.goodbyeView = new GoodbyeView()
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
    void goodbye(GoodbyeController goodbyeController) {
        this.goodbyeView.show(goodbyeController)
    }

    @Override
    boolean resume(ResumeController resumeController) {
        return this.resumeView.resume(resumeController)
    }
}
