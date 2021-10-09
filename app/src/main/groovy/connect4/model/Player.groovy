package connect4.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@EqualsAndHashCode
@TupleConstructor(defaults = false, useSetters = false)
class Player {
    Color color

    boolean hasColor() {
        return true
    }
}
