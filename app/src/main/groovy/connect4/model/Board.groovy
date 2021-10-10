package connect4.model

class Board {
    private static final Integer NUMBER_OF_ROWS = 7
    private static final Integer NUMBER_OF_COLUMNS = 6
    private static final Range<Integer> ROWS = (0..<NUMBER_OF_ROWS)
    private static final Range<Integer> ROWS_MINUS_THREE = (0..(NUMBER_OF_COLUMNS - 3))
    private static final Range<Integer> COLS = (0..<NUMBER_OF_COLUMNS)
    private static final Range<Integer> COLS_MINUS_THREE = (0..(NUMBER_OF_COLUMNS - 3))

    private Color[][] board = new Color[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS]
    private Color last = Color.NULL

    Board() {
        this.reset()
    }

    void reset() {
        [ROWS, COLS].combinations().each { Integer row, Integer col ->
            this.fillCell(Color.NULL, new Coordinate(row, col))
        }
    }

    boolean isEmptyAt(Coordinate coordinate) {
        return this.board[coordinate.row][coordinate.column] == Color.NULL
    }

    static boolean isWithinBounds(Coordinate coordinate) {
        return coordinate.row < NUMBER_OF_ROWS && coordinate.column < NUMBER_OF_COLUMNS
    }

    Board fillCell(Color color, Coordinate coordinate) {
        this.last = color
        this.board[coordinate.row][coordinate.column] = this.last
        return this
    }

    List<Color[]> getSnapshot() {
        return this.board.collect()
    }

    boolean isConnect4() {
        return this.isInRows() || this.isInCols() || this.isInDiagonal() || this.isInInvertedDiagonal()
    }

    private boolean isInRows() {
        return [COLS_MINUS_THREE, ROWS].combinations().any { int c, int r ->
            return board[r][c] == last && board[r][c+1] == last && board[r][c+2] == last && board[r][c+3] == last
        }
    }

    private boolean isInCols() {
        return [COLS, ROWS_MINUS_THREE].combinations().any { int c, int r ->
            return board[r][c] == last && board[r+1][c] == last && board[r+2][c] == last && board[r+3][c] == last
        }
    }

    private boolean isInDiagonal() {
        return [COLS_MINUS_THREE, ROWS_MINUS_THREE].combinations().any { int c, int r ->
            return board[r][c] == last && board[r+1][c+1] == last && board[r+2][c+2] == last && board[r+3][c+3] == last
        }
    }

    private boolean isInInvertedDiagonal() {
        return [COLS_MINUS_THREE, ROWS].combinations().any { int c, int r ->
            return board[r][c] == last && board[r-1][c+1] == last && board[r-2][c+2] == last && board[r-3][c+3] == last
        }
    }
}
