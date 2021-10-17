package connect4.model

class AIPlayer(color: Color): Player(color) {
    override fun <T> accepts(visitor: PlayerVisitor<T>): T {
        return visitor.visit(this)
    }
}