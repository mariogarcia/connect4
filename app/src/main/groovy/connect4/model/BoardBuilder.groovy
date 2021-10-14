package connect4.model

class BoardBuilder {
    private Integer rows = 7
    private Integer columns = 6
    private Integer winningMoves = 4

    BoardBuilder withColumns(Integer columns) {
        this.columns = columns
        return this
    }

    BoardBuilder withRows(Integer rows) {
        this.rows = rows
        return this
    }

    BoardBuilder withRequiredWinningMoves(Integer numberOfWinningMoves) {
        this.winningMoves = numberOfWinningMoves
        return this
    }

    Board build() {
        return new Board(new BoardRestrictions(rows, columns, winningMoves))
    }
}
