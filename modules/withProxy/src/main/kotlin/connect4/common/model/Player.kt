package connect4.common.model

abstract class Player(val color: Color) {
    abstract fun <T> accepts(visitor: PlayerVisitor<T>): T
}