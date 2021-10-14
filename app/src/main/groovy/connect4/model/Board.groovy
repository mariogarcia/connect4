package connect4.model

class Board {
    private Color[][] board
    private Coordinate last
    private BoardRestrictions restrictions

    Board(BoardRestrictions restrictions) {
        this.restrictions = restrictions
        this.last = new NullCoordinate()
        this.board = new Color[restrictions.rows][restrictions.columns]

        this.reset()
    }

    void reset() {
        [(0..<restrictions.rows), (0..<restrictions.columns)]
            .combinations()
            .each { Integer row, Integer col ->
                this.fillCell(Color.NULL, new Coordinate(row, col))
            }
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.isEmptyAt(coordinate) && this.isWithinBounds(coordinate)
    }

    private boolean isEmptyAt(Coordinate coordinate) {
        return this.board[coordinate.row][coordinate.column] == Color.NULL
    }

    Board fillCell(Color color, Coordinate coordinate) {
        this.last = coordinate
        this.board[coordinate.row][coordinate.column] = color
        return this
    }

    List<Color[]> getSnapshot() {
        return this.board.collect()
    }

    boolean isConnect4() {
        return Coordinate.Directions
            .values()
            .collect {this.last.getNeighbors(this.restrictions.howManyToWin, it) }
            .findAll(this::havingCoordinatesWithinBounds)
            .collect(this::getColorsFromCoordinates)
            .any(Board::hasAllCoordinatesWithSameColor)
    }

    private boolean havingCoordinatesWithinBounds(List<Coordinate> coordinates) {
        return coordinates.every(this::isWithinBounds)
    }

    private boolean isWithinBounds(Coordinate coordinate) {
        return coordinate.row < this.restrictions.rows && coordinate.column < this.restrictions.columns
    }

    private List<Color> getColorsFromCoordinates(List<Coordinate> coordinates) {
        return coordinates.collect {board[it.row][it.column] }
    }

    private static boolean hasAllCoordinatesWithSameColor(List<Color> colors) {
        return colors.toUnique().size() == 1
    }
}
