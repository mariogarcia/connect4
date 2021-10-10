package connect4.controller

import connect4.model.Game
import connect4.model.State
import connect4.model.StateValue

class Logic {
    private Game game
    private State state
    private Map<StateValue, Controller> controllers

    Logic() {
        this.game = new Game()
        this.state = new State()
        this.controllers = [
            (StateValue.START): new StartController(this.game, this.state),
            (StateValue.PLAY): new PlayController(this.game, this.state),
            (StateValue.RESUME): new ResumeController(this.game, this.state),
            (StateValue.GOODBYE): new GoodbyeController(this.game, this.state)
        ]
    }

    Controller getController() {
        return this.controllers[this.state.value]
    }
}
