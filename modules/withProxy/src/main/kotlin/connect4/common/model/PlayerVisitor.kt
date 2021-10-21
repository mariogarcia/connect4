package connect4.common.model

interface PlayerVisitor<T> {
    fun visit(aiPlayer: AIPlayer): T
    fun visit(humanPlayer: HumanPlayer): T
}