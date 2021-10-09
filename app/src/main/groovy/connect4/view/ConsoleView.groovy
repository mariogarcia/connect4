package connect4.view

import connect4.model.Game

abstract class ConsoleView extends WithGameView{
    ConsoleView(Game game) {
        super(game)
    }

    @Override
    Renderer getRenderer() {
        return new ConsoleRenderer()
    }
}
