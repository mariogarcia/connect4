package connect4.model

import connect4.model.Coordinate.Directions

class Board {
    private Color[][] board
    private Coordinate lastMove
    private BoardRestrictions restrictions

    Board(BoardRestrictions restrictions) {
        this.restrictions = restrictions
        this.lastMove = new NullCoordinate()
        this.board = new Color[restrictions.rows][restrictions.columns]

        this.reset()
    }

    void reset() {
        (0..<restrictions.rows).each { Integer row ->
            (0..<restrictions.columns).each { Integer col ->
                this.fillCell(new NullPlayer(), new Coordinate(row, col))
            }
        }
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.isEmptyAt(coordinate) && this.isWithinBounds(coordinate)
    }

    private boolean isEmptyAt(Coordinate coordinate) {
        return this.board[coordinate.row][coordinate.column].isNull()
    }

    Board fillCell(Player player, Coordinate coordinate) {
        this.lastMove = coordinate
        this.board[coordinate.row][coordinate.column] = player.color
        return this
    }

    List<Color[]> getSnapshot() {
        return this.board.collect()
    }

    private boolean isWithinBounds(Coordinate coordinate) {
        return coordinate.row < this.restrictions.rows && coordinate.column < this.restrictions.columns
    }

    boolean isConnect4() {
        return Directions
            .values()
            .collect { this.lastMove.getNeighbors(this.restrictions.howManyToWin, it) }
            .findAll { it.every(this::isWithinBounds)}
            .collect { coordinates -> coordinates.collect {board[it.row][it.column] }}
            .any { it.toUnique().size() == 1}
    }
}
