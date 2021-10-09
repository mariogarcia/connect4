package connect4.model

class Turn {
    private static final int NUMBER_OF_PLAYERS = 2

    private List<Player> players
    private Board board
    private boolean firstPlayerTurn

    Turn(Board board) {
        assert board != null, "board must not be null"

        this.board = board
        this.players = []
        this.firstPlayerTurn = true
        this.reset()
    }

    void reset() {
        this.players = [new Player(Color.RED), new Player(Color.BLACK)]
        this.board.reset()
        this.firstPlayerTurn = true
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.board.isWithinBounds(coordinate) && this.board.isEmptyAt(coordinate)
    }

    boolean isValidCoordinate(NullCoordinate coordinate) {
        return false
    }

    void playWithCoordinate(Coordinate coordinate) {
        this.board.fillCell(currentPlayer.color, coordinate)
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
