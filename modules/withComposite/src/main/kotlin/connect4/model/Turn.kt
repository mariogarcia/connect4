package connect4.model

class Turn(private val board: Board): PlayerVisitor<Player> {
    private var players: List<Player> = listOf(HumanPlayer(Color.RED), AIPlayer(Color.BLUE))
    private var activePlayer: Player = players.first()

    fun reset() {
        this.players = listOf(HumanPlayer(Color.RED), AIPlayer(Color.BLUE))
        this.board.reset()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.board.isValidCoordinate(coordinate)
    }

    fun isValidCoordinate(coordinate: NullCoordinate): Boolean = false

    fun playWithCoordinate(coordinate: Coordinate) {
        this.board.fillCell(this.getCurrentPlayer(), coordinate)
    }

    fun getCurrentPlayer(): Player {
        return this.activePlayer
    }

    private fun getNextPlayer(player: Player): Player {
        return player.accepts(this)
    }

    fun setActivePlayer(player: Player) {
        this.activePlayer = player
    }

    fun togglePlayer() {
        this.activePlayer = getNextPlayer(this.activePlayer)
    }

    fun getPlayers(): List<Player> {
        return this.players
    }

    override fun visit(aiPlayer: AIPlayer): Player {
        return this.players.first()
    }

    override fun visit(humanPlayer: HumanPlayer): Player {
        return this.players.last()
    }

    override fun visit(nullPlayer: NullPlayer): Player {
        throw Exception("No contender exists for a NullPlayer")
    }
}