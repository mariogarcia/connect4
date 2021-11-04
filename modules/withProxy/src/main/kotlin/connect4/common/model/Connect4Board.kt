package connect4.common.model

class Connect4Board: Board(7, 6, 4) {
    override fun copy(): Board {
        val boardCopy = Connect4Board()
        this.cells.forEach(boardCopy::fillCell)
        return boardCopy
    }
}