package connect4.model

class Game {
    private val board = BoardBuilder().build()
    private val turn = Turn(board)

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
}