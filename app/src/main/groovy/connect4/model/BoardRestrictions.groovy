package connect4.model

import groovy.transform.TupleConstructor

@TupleConstructor(defaults = false, useSetters = false)
class BoardRestrictions {
    Integer rows
    Integer columns
    Integer howManyToWin
}
