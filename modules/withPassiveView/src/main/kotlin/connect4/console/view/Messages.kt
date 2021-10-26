package connect4.console.view

enum class Messages(private val message: String) {
    GREETINGS("""
@|green                                  _            ___      |@
@|green                                 | |          /   |     |@
@|green   ___ ___  _ __  _ __   ___  ___| |_ ______ / /| |     |@
@|green  / __/ _ \\| '_ \\| '_ \\ / _ \\/ __| __|______/ /_| | |@
@|green | (_| (_) | | | | | | |  __/ (__| |_       \\___  |    |@
@|green \\___\\___/|_| |_|_| |_|\\___|\\___|\\__|          |_/ |@
"""),
    NEXT_MOVE_QUESTION("Introduce a new move [%s]: "),
    NEW_GAME_QUESTION("Would you like to play another game ?");

    companion object {
        fun Messages.format(vararg params: String): String {
            return String.format(this.message, *params)
        }
    }

    override fun toString(): String = this.message
}