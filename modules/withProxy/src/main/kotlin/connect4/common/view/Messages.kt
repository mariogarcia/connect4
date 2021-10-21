package connect4.common.view

enum class Messages(private val message: String) {
    GOOD_BYE("""
@|green                                          _     _   _                _           |@
@|green                                         | |   | | (_)              | |          |@
@|green  ___  ___  ___   _   _   _ __   _____  _| |_  | |_ _ _ __ ___   ___| |          |@
@|green / __|/ _ \\/ _ \\ | | | | | '_ \\ / _ \\ \\/ / __| | __| | '_ ` _ \\ / _ \\ |   |@
@|green \\__ \\  __/  __/ | |_| | | | | |  __/>  <| |_  | |_| | | | | | |  __/_|        |@
@|green |___/\\___|\\___|  \\__,_| |_| |_|\\___/_/\\_\\\\__|  \\__|_|_| |_| |_|\\___(_) |@
"""),
    GREETINGS("""
@|green                                  _            ___      |@
@|green                                 | |          /   |     |@
@|green   ___ ___  _ __  _ __   ___  ___| |_ ______ / /| |     |@
@|green  / __/ _ \\| '_ \\| '_ \\ / _ \\/ __| __|______/ /_| | |@
@|green | (_| (_) | | | | | | |  __/ (__| |_       \\___  |    |@
@|green \\___\\___/|_| |_|_| |_|\\___|\\___|\\__|          |_/ |@
"""),
    NEXT_MOVE_QUESTION("Introduce a new move [%s]: "),
    NEW_GAME_QUESTION("Would you like to play another game ?"),
    MENU_OPTION_CHOOSE("----- Choose one option -----"),
    COMMAND_ACTION("Keep playing"),
    COMMAND_UNDO("Undo movement"),
    COMMAND_REDO("Redo movement");


    companion object {
        fun Messages.format(vararg params: String): String {
            return String.format(this.message, *params)
        }

        fun nextAISentence(): String {
            val sentences = Messages::class.java
                .getResource("/ai_sentences.txt")
                ?.readText(Charsets.UTF_8)
                ?.lines()
                ?.shuffled()
                ?.first()

            return "All right my turn... @|yellow $sentences |@"
        }
    }

    override fun toString(): String = this.message
}