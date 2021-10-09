package connect4.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@EqualsAndHashCode(includes = ["coordinate"])
@TupleConstructor(defaults = false, useSetters = false)
class Cell {
    Coordinate coordinate
    Player player

    boolean isEmpty() {
        return this.player.hasColor()
    }
}
