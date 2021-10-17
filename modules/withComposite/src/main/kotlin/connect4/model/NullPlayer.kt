package connect4.model

class NullPlayer: Player(Color.NULL) {
    override fun <T> accepts(visitor: PlayerVisitor<T>): T {
        return visitor.visit(this)
    }
}