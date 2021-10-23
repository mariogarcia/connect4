package connect4.standalone.model

import connect4.common.model.*
import connect4.common.model.Session as CommonSession

class Session: CommonSession {
    private val game = Game()
    private val state = State()
    private val registry = GameRegistry(game)

    override fun getStateValue(): StateValue {
        return this.state.value
    }

    fun next() {
        this.state.next()
    }

    fun getBoardColors(): List<Array<Color>> {
        return this.game.getBoardColors()
    }

    fun reset() {
        this.game.reset()
        this.state.reset()
    }

    fun playWithCoordinate(coordinate: Coordinate) {
        this.game.playWithCoordinate(coordinate)
        this.registry.register()
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

    fun redo() {
        this.registry.redo()
    }

    fun isRedoable(): Boolean {
        return this.registry.isRedoable()
    }

    fun undo() {
        this.registry.undo()
    }

    fun isUndoable(): Boolean {
        return this.registry.isUndoable()
    }
}