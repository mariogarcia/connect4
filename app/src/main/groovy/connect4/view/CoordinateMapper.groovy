package connect4.view

import connect4.model.Coordinate
import connect4.model.NullCoordinate
import org.codehaus.groovy.runtime.StringGroovyMethods

class CoordinateMapper implements InputMapper<Coordinate> {
    @Override
    Coordinate fromString(String input) {
        List<Integer> rowCol = input
            .split(",")
            .findAll(StringGroovyMethods::isNumber)
            .collect(Integer::parseInt)

        if (rowCol.size() == 2) {
            return new Coordinate(rowCol.first(), rowCol.last())
        }

        return new NullCoordinate()
    }
}
