package connect4.model

class Game {
    private Turn turn
    private Board board

    Game() {
        this.board = new Board()
        this.turn = new Turn(this.board)
    }

    void reset() {
        this.turn.reset()
        this.board.reset()
    }

    boolean isConnect4() {
        return this.turn.isConnect4()
    }

    Player getCurrentPlayer() {
        return this.turn.currentPlayer
    }

    void playWithCoordinate(Coordinate nextMove) {
        this.turn.playWithCoordinate(nextMove)
    }

    void togglePlayer() {
        this.turn.togglePlayer()
    }

    boolean isValidCoordinate(Coordinate coordinate) {
        return this.turn.isValidCoordinate(coordinate)
    }

    Color[][] getBoardSnapshot() {
        return this.board.snapshot
    }
}
