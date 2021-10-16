package connect4.view

import connect4.model.AIPlayer
import connect4.model.Player

@Singleton(lazy = true)
class PlayInputViewFactory {
    private final PlayInputView humanView = new PlayInputHumanView()
    private final PlayInputView aiView = new PlayInputAIView()

    PlayInputView getViewByPlayer(AIPlayer aiPlayer) {
        return this.aiView
    }

    PlayInputView getViewByPlayer(Player humanPlayer) {
        return this.humanView
    }
}
