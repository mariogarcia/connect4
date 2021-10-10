package connect4.view

enum Messages {
    GOOD_BYE("Bye bye, see u next time!"),
    GREETINGS("Hi stranger!"),
    NEXT_MOVE_QUESTION("Introduce a new move [%s]:"),
    NEW_GAME_QUESTION("Would you like to play another game ?"),
    BAD_COORDINATE("Wrong position pal! Give me another one please")

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
}