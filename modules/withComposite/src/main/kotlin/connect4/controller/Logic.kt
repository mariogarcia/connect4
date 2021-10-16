package connect4.controller

import connect4.model.Game
import connect4.model.State
import connect4.model.StateValue

class Logic {
    private val state: State = State()
    private val game: Game = Game()
    private val controllers: Map<StateValue, Controller> = mapOf(
        Pair(StateValue.START, StartController(game, state)),
        Pair(StateValue.PLAY, PlayController(game, state)),
        Pair(StateValue.RESUME, ResumeController(game, state))
    )

    fun getController(): Controller? {
        return this.controllers[this.state.value]
    }
}