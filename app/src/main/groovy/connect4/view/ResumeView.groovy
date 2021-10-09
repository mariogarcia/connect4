package connect4.view

import connect4.i18n.Messages
import connect4.model.Game

class ResumeView extends ConsoleView {
    ResumeView(Game game) {
        super(game)
    }

    boolean resume() {
        return this.renderer.askBoolean(Messages.NEW_GAME_QUESTION.toString())
    }
}
