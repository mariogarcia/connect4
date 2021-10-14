package connect4.view

enum Messages {
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
    BAD_COORDINATE("Wrong position pal! Give me another one please"),

    private String message

    Messages(String message) {
        this.message = message
    }

    String toString() {
        return this.message
    }

    String format(Object... params) {
        return String.format(this.message, params)
    }

    static String nextAISentence() {
        String chuckSentence = Messages.class.classLoader
            .getResource("ai_sentences.txt")
            .readLines()
            .shuffled()
            .find()

        return "All right my turn... @|yellow $chuckSentence |@"
    }
}