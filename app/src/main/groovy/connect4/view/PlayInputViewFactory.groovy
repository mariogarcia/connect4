package connect4.view

import connect4.model.AIPlayer
import connect4.model.Player

@Singleton(lazy = true)
class PlayInputViewFactory {
    private final PlayInputView humanView = new PlayInputHumanView()
    private final PlayInputView aiView = new PlayInputAIView()

    PlayInputView getByPlayer(AIPlayer aiPlayer) {
        return this.aiView
    }

    PlayInputView getByPlayer(Player humanPlayer) {
        return this.humanView
    }
}
