package connect4.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Coordinate {

    static enum Directions {
        HORIZONTAL_LEFT(0, 1),
        HORIZONTAL_RIGHT(0, -1),
        VERTICAL_UP(-1, 0),
        VERTICAL_DOWN(1, 0),
        DIAGONAL_MAIN_UP(-1, -1),
        DIAGONAL_MAIN_DOWN(1, 1),
        DIAGONAL_INVERTED_UP(-1, 1),
        DIAGONAL_INVERTED_DOWN(1, -1)

        private Integer alpha, beta

        Directions(Integer alpha, Integer beta) {
            this.alpha = alpha
            this.beta = beta
        }
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
        return new Coordinate(this.row + (index * directions.alpha), this.column + (index * directions.beta))
    }
}
