package connect4.model

class GameRegistry(private val game: Game) {
    private val snapshots: MutableList<GameSnapshot> = mutableListOf()
    private var step: Int = 0

    fun reset() {
        this.snapshots.clear()
        this.snapshots.add(0, this.game.createSnapshot())
    }

    fun register() {
        this.snapshots.add(this.step, this.game.createSnapshot())
        this.step++
    }

    fun undo() {
        assert(this.isUndoable()) { "error due to user trying to undo an undoable state of the game" }
        this.game.setSnapshot(this.getListIterator().previous())
        this.step--
    }

    fun redo() {
        assert(this.isRedoable()) { "error due to user trying to redo a not redo-able state of the game" }
        this.game.setSnapshot(this.getListIterator().next())
        this.step++
    }

    fun isUndoable(): Boolean {
        return this.getListIterator().hasPrevious()
    }

    fun isRedoable(): Boolean {
        return this.getListIterator().hasNext()
    }

    private fun getListIterator(): ListIterator<GameSnapshot> {
        return snapshots.listIterator(this.step)
    }
}