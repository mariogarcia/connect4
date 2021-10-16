package connect4.model

class Turn(private val board: Board) {
    private var players: List<Player> = listOf(HumanPlayer(Color.RED), AIPlayer(Color.BLUE))
    private var firstPlayerTurn: Boolean = false

    fun reset() {
        this.players = listOf(HumanPlayer(Color.RED), AIPlayer(Color.BLUE))
        this.board.reset()
        this.firstPlayerTurn = true
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.board.isValidCoordinate(coordinate)
    }

    fun isValidCoordinate(coordinate: NullCoordinate): Boolean = false

    fun playWithCoordinate(coordinate: Coordinate) {
        this.board.fillCell(this.getCurrentPlayer(), coordinate)
    }

    fun getCurrentPlayer(): Player {
        return if (this.firstPlayerTurn) this.players.first() else this.players.last()
    }

    fun togglePlayer() {
        this.firstPlayerTurn = !this.firstPlayerTurn
    }
}