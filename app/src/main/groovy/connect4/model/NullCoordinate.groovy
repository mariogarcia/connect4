package connect4.model

class NullCoordinate extends Coordinate {
    NullCoordinate() {
        super(0, 0)
    }

    @Override
    List<Coordinate> getNeighbors(Integer howMany, Directions direction) {
        return []
    }
}
