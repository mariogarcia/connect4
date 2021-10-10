package connect4.view

import connect4.model.Game

class GameView {
    private StartView startView
    private PlayView playView
    private ResumeView resumeView
    private GoodbyeView goodbyeView
    private Game game

    GameView(Game game) {
        this.game = game
        this.startView = new StartView(this.game)
        this.playView = new PlayView(this.game)
        this.resumeView = new ResumeView(this.game)
        this.goodbyeView = new GoodbyeView(this.game)
    }

    void start() {
        this.startView.show()
    }

    void play() {
        this.playView.interact()
    }

    boolean resume() {
        return this.resumeView.resume()
    }

    void goodbye() {
        this.goodbyeView.show()
    }
}
