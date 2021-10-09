package connect4.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
@EqualsAndHashCode
class Coordinate {
    int row
    int column
}
