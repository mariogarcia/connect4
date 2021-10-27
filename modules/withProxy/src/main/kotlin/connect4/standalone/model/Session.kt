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

    override fun next() {
        this.state.next()
    }

    override fun getBoardColors(): List<Array<Color>> {
        return this.game.getBoardColors()
    }

    override fun reset() {
        this.game.reset()
        this.state.reset()
    }

    override fun playWithCoordinate(coordinate: Coordinate) {
        this.game.playWithCoordinate(coordinate)
        this.registry.register()
        this.game.togglePlayer()
    }

    override fun isConnect4(): Boolean {
        return this.game.isConnect4()
    }

    override fun isValidCoordinate(coordinate: Coordinate): Boolean {
        return this.game.isValidCoordinate(coordinate)
    }

    override fun getCurrentPlayer(): Player {
        return this.game.getCurrentPlayer()
    }

    override fun redo() {
        this.registry.redo()
    }

    override fun isRedoable(): Boolean {
        return this.registry.isRedoable()
    }

    override fun undo() {
        this.registry.undo()
    }

    override fun isUndoable(): Boolean {
        return this.registry.isUndoable()
    }
}