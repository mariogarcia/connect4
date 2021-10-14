package connect4.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Coordinate {

    static enum Directions {
        HORIZONTAL_LEFT,
        HORIZONTAL_RIGHT,
        VERTICAL_UP,
        VERTICAL_DOWN,
        DIAGONAL_MAIN_UP,
        DIAGONAL_MAIN_DOWN,
        DIAGONAL_INVERTED_UP,
        DIAGONAL_INVERTED_DOWN
    }

    private final Integer row
    private final Integer column

    Coordinate(Integer row, Integer column) {
        this.row = row
        this.column = column
    }

    List<Coordinate> getNeighbors(Integer howMany, Directions direction) {
        return (0..<howMany).collect { Integer delta ->
            applyDelta(delta, direction)
        }
    }

    private Coordinate applyDelta(Integer index, Directions directions) {
        switch(directions) {
            case Directions.HORIZONTAL_RIGHT:        return new Coordinate(this.row, this.column + index)
            case Directions.HORIZONTAL_LEFT:         return new Coordinate(this.row, this.column - index)
            case Directions.VERTICAL_UP:             return new Coordinate(this.row - index, this.column)
            case Directions.VERTICAL_DOWN:           return new Coordinate(this.row + index, this.column)
            case Directions.DIAGONAL_MAIN_UP:        return new Coordinate(this.row - index, this.column - index)
            case Directions.DIAGONAL_MAIN_DOWN:      return new Coordinate(this.row + index, this.column + index)
            case Directions.DIAGONAL_INVERTED_UP:    return new Coordinate(this.row - index, this.column + index)
            case Directions.DIAGONAL_INVERTED_DOWN:  return new Coordinate(this.row + index, this.column - index)
        }
    }
}
