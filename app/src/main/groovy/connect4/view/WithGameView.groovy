package connect4.view

import connect4.model.Game
import groovy.transform.TupleConstructor

@TupleConstructor(defaults = false, useSetters = false)
abstract class WithGameView implements View {
    Game game
}