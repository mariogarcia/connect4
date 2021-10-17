package connect4.model

class GameLogger(private val game: Game) {
    private val snapshots: MutableList<GameSnapshot> = mutableListOf()
    private var previous = 0

    fun reset() {
        this.previous = 0
        this.snapshots.clear()
        this.snapshots.add(0, this.game.createSnapshot())
    }

    fun register() {
        (0 until this.previous).forEach { this.snapshots.removeAt(it) }

        this.previous = 0
        this.snapshots.add(this.previous, this.game.createSnapshot())
    }

    fun undo() {
        assert(this.isUndoable()) { "error due to user trying to undo an undoable state of the game" }

        this.previous++
        this.game.setSnapshot(this.snapshots[this.previous])
    }

    fun redo() {
        assert(this.isRedoable()) { "error due to user trying to redo a not redo-able state of the game" }

        this.previous--
        this.game.setSnapshot(this.snapshots[this.previous])
    }

    private fun isUndoable(): Boolean {
        return this.previous < this.snapshots.size
    }

    private fun isRedoable(): Boolean {
        return this.previous >= 1
    }
}