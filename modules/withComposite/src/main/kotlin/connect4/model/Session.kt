package connect4.model

class Session {
    private val game = Game()
    private val state = State()
    private val logger = GameLogger(game)

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

    fun redo() {
        this.logger.redo()
    }

    fun isRedoable(): Boolean {
        return this.logger.isRedoable()
    }

    fun undo() {
        this.logger.undo()
    }

    fun isUndoable(): Boolean {
        return this.logger.isUndoable()
    }

    fun register() {
        this.logger.register()
    }
}