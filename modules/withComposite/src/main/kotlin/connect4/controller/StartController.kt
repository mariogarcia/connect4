package connect4.controller

import connect4.model.Game
import connect4.model.State

class StartController(private val game: Game, private val state: State): BoardController(game, state) {
    fun reset() {
        this.game.reset()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}