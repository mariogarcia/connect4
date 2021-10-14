package connect4.model

import groovy.transform.TupleConstructor

@TupleConstructor(defaults = false, useSetters = false)
abstract class Player {
    Color color
}
