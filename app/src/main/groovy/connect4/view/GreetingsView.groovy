package connect4.view

import connect4.model.Game
import connect4.i18n.Messages

class GreetingsView extends ConsoleView {
    static final String BANNER = """
  _____                       __      ____
 / ___/__  ___  ___  ___ ____/ /_____/ / /
/ /__/ _ \\/ _ \\/ _ \\/ -_) __/ __/___/_  _/
\\___/\\___/_//_/_//_/\\__/\\__/\\__/     /_/  
"""

    GreetingsView(Game game) {
        super(game)
    }

    void interact() {
        this.renderer.writeln(BANNER)
    }
}
