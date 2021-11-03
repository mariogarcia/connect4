package connect4.model

class NullCoordinate: Coordinate(0, 0) {
    override fun getNeighbors(howMany: Int, direction: Direction): List<Coordinate> = listOf()
}