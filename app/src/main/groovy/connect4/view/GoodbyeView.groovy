package connect4.view

import connect4.i18n.Messages
import connect4.model.Game

class GoodbyeView extends ConsoleView {
    GoodbyeView(Game game) {
        super(game)
    }

    void show() {
        this.renderer.writeln(Messages.GOOD_BYE.toString())
    }
}
