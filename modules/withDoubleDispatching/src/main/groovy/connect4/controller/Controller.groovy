package connect4.controller

import connect4.model.Game
import connect4.model.State
import groovy.transform.TupleConstructor

@TupleConstructor(defaults = false, useSetters = false)
abstract class Controller {
    Game game
    State state

    void nextState() {
        this.state.next()
    }

    abstract void accept(ControllersVisitor controllersVisitor)
}