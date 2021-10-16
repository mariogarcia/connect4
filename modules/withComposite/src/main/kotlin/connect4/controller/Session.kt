package connect4.controller

import connect4.model.*

class Session {
    private val game = Game()
    private val state = State()

    fun getStateValue(): StateValue {
        return this.state.value
    }

    fun next() {
        this.state.next()
    }

    fun getBoardSnapshot(): List<Array<Color>> {
        return this.game.getBoardSnapshot()
    }

    fun reset() {
        this.game.reset()
        this.state.reset()
    }

    fun playWithCoordinate(coordinate: Coordinate) {
        this.game.playWithCoordinate(coordinate)
    }

    fun togglePlayer() {
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
