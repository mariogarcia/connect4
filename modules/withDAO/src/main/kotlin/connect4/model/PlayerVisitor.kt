package connect4.model

interface PlayerVisitor<T> {
    fun visit(aiPlayer: AIPlayer): T
    fun visit(humanPlayer: HumanPlayer): T
}