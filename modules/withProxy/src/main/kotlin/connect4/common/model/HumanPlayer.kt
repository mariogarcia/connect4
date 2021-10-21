package connect4.common.model

class HumanPlayer(color: Color): Player(color) {
    override fun <T> accepts(visitor: PlayerVisitor<T>): T {
        return visitor.visit(this)
    }
}