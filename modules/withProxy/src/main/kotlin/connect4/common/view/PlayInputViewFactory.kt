package connect4.common.view

import connect4.common.model.AIPlayer
import connect4.common.model.HumanPlayer
import connect4.common.model.Player
import connect4.common.model.PlayerVisitor

object PlayInputViewFactory: PlayerVisitor<PlayInputView> {
    fun getViewByPlayer(player: Player): PlayInputView {
        return player.accepts(this)
    }

    override fun visit(aiPlayer: AIPlayer): PlayInputView {
        return PlayInputAIView()
    }

    override fun visit(humanPlayer: HumanPlayer): PlayInputView {
        return PlayInputHumanView()
    }
}