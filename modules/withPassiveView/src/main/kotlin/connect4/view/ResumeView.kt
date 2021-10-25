package connect4.view


class ResumeView {
    fun resume(): Boolean {
        return Console.askBoolean(Messages.NEW_GAME_QUESTION.toString())
    }
}