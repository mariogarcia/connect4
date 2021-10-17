package connect4.model

class Game {
    private var board = BoardBuilder().build()
    private var turn = Turn(board)

    fun reset() {
        this.turn.reset()
        this.board.reset()
    }

    fun isConnect4(): Boolean {
        return this.board.isConnect4()
    }

    fun getCurrentPlayer(): Player {
        return this.turn.getCurrentPlayer()
    }

    fun playWithCoordinate(coordinate: Coordinate) {
        this.turn.playWithCoordinate(coordinate)
    }

    fun togglePlayer() {
        this.turn.togglePlayer()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.turn.isValidCoordinate(coordinate)
    }

    fun getBoardSnapshot(): List<Array<Color>>  {
        return this.board.getSnapshot()
    }

    fun createSnapshot(): GameSnapshot {
        return GameSnapshot(this.board, this.turn)
    }

    fun setSnapshot(snapshot: GameSnapshot) {
        board = snapshot.getBoard()
        turn = Turn(board)
        turn.setActivePlayer(snapshot.getActivePlayer())
    }
}