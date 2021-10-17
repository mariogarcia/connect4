package connect4.view

import connect4.model.*
import java.lang.Exception

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

    override fun visit(nullPlayer: NullPlayer): PlayInputView {
        throw Exception("No PlayInputView exists for NullPlayer")
    }
}