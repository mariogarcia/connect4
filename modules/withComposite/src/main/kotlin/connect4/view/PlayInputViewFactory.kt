package connect4.view

import connect4.model.AIPlayer
import connect4.model.HumanPlayer
import connect4.model.Player

object PlayInputViewFactory {
    fun getViewByPlayer(player: Player): PlayInputView {
        // NO POLYMORPHISM BY OVERWRITING IN KOTLIN :(
        return when(player) {
            is HumanPlayer -> PlayInputHumanView()
            is AIPlayer -> PlayInputAIView()
            else -> PlayInputHumanView()
        }
    }
}