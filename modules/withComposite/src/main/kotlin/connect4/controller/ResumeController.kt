package connect4.controller

import connect4.model.Game
import connect4.model.State

class ResumeController(private val game: Game, private val state: State): Controller(game, state) {
    fun reset() {
        this.game.reset()
        this.state.reset()
    }
    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}
