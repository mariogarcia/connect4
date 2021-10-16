package connect4.model

class Turn {
    private List<Player> players
    private Board board
    private boolean firstPlayerTurn

    Turn(Board board) {
        assert board != null, "board must not be null"

        this.board = board
        this.firstPlayerTurn = true
        this.reset()
    }

    void reset() {
        this.players = [new HumanPlayer(Color.RED), new AIPlayer(Color.BLACK)]
        this.board.reset()
        this.firstPlayerTurn = true
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.board.isValidCoordinate(coordinate)
    }

    boolean isValidCoordinate(NullCoordinate coordinate) {
        return false
    }

    void playWithCoordinate(Coordinate coordinate) {
        this.board.fillCell(currentPlayer, coordinate)
    }

    void togglePlayer() {
        this.firstPlayerTurn = !this.firstPlayerTurn
    }

    Player getCurrentPlayer() {
        return this.firstPlayerTurn ? this.players.first() : this.players.last()
    }

    boolean isConnect4() {
        return this.board.isConnect4()
    }
}
