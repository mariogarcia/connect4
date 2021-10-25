package connect4.model

class Turn(private val board: Board) {
    private var players: List<Player> = listOf(Player(Color.RED), Player(Color.BLUE))
    private var activePlayer: Player = players.first()

    fun reset() {
        this.players = listOf(Player(Color.RED), Player(Color.BLUE))
        this.board.reset()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.board.isValidCoordinate(coordinate)
    }

    fun isValidCoordinate(coordinate: NullCoordinate): Boolean = false

    fun playWithCoordinate(coordinate: Coordinate) {
        this.board.fillCell(coordinate, this.getCurrentPlayer())
    }

    fun getCurrentPlayer(): Player {
        return this.activePlayer
    }

    fun setActivePlayer(player: Player) {
        this.activePlayer = player
    }

    fun getPlayers(): List<Player> {
        return this.players
    }

    fun togglePlayer() {
        this.activePlayer = getNextPlayer(this.activePlayer)
    }

    private fun getNextPlayer(player: Player): Player {
        val firstPlayer = this.players.first()

        return if (firstPlayer.color == player.color)
            this.players.last() else
            this.players.first()
    }
}