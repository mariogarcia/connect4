package connect4.model

data class BoardBuilder(
    var rows: Int = 7,
    var cols: Int = 6,
    var winningMoves: Int = 4
) {
    fun withRows(rows: Int) = apply { this.rows = rows }
    fun withCols(cols: Int) = apply { this.cols = cols }
    fun withWinningMoves(moves: Int) = apply { this.winningMoves = moves }
    fun build() = Board(BoardRestrictions(rows, cols, winningMoves))
}