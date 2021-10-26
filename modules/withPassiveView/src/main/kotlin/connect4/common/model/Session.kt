package connect4.common.model

class Session {
    private val game = Game()

    fun getBoardColors(): List<Array<Color>> {
        return this.game.getBoardColors()
    }

    fun reset() {
        this.game.reset()
    }

    fun playWithCoordinate(coordinate: Coordinate) {
        this.game.playWithCoordinate(coordinate)
        this.game.togglePlayer()
    }

    fun isConnect4(): Boolean {
        return this.game.isConnect4()
    }

    fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.game.isValidCoordinate(coordinate)
    }

    fun getCurrentPlayer(): Player {
        return this.game.getCurrentPlayer()
    }
}
