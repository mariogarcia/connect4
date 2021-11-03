package connect4.model

class GameSnapshot(private val board: Board, private val activePlayer: Player) {
    fun getBoard(): Board {
        return this.board
    }

    fun getActivePlayer(): Player {
        return this.activePlayer
    }
}