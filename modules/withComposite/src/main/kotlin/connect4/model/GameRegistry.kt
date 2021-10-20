package connect4.model

class GameRegistry(private val game: Game) {
    private val snapshots: MutableList<GameSnapshot> = mutableListOf()
    private var step: Int = 0

    init {
        this.register()
    }

    fun register() {
        this.snapshots.add(this.step, this.game.createSnapshot())
        this.step++
    }

    fun undo() {
        assert(this.isUndoable()) { "error due to user trying to undo an undoable state of the game" }
        this.step--
        this.game.setSnapshot(this.snapshots[step - 1])
    }

    fun redo() {
        assert(this.isRedoable()) { "error due to user trying to redo a not redo-able state of the game" }
        this.game.setSnapshot(this.snapshots[step])
        this.step++
    }

    fun isUndoable(): Boolean {
        return this.step > 1
    }

    fun isRedoable(): Boolean {
        return this.step < this.snapshots.size
    }
}