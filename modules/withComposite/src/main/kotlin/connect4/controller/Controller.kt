package connect4.controller

import connect4.model.Game
import connect4.model.State

abstract class Controller(private val game: Game, private val state: State) {
    fun nextState() {
        this.state.next()
    }

    abstract fun accept(visitor: ControllersVisitor)
}