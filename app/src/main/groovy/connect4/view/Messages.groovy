package connect4.view

enum Messages {
    GOOD_BYE("""
                                         _     _   _                _ 
                                        | |   | | (_)              | |
 ___  ___  ___   _   _   _ __   _____  _| |_  | |_ _ _ __ ___   ___| |
/ __|/ _ \\/ _ \\ | | | | | '_ \\ / _ \\ \\/ / __| | __| | '_ ` _ \\ / _ \\ |
\\__ \\  __/  __/ | |_| | | | | |  __/>  <| |_  | |_| | | | | | |  __/_|
|___/\\___|\\___|  \\__,_| |_| |_|\\___/_/\\_\\\\__|  \\__|_|_| |_| |_|\\___(_)
"""),
    GREETINGS("""
                                 _            ___ 
                                | |          /   |
  ___ ___  _ __  _ __   ___  ___| |_ ______ / /| |
 / __/ _ \\| '_ \\| '_ \\ / _ \\/ __| __|______/ /_| |
| (_| (_) | | | | | | |  __/ (__| |_       \\___  |
 \\___\\___/|_| |_|_| |_|\\___|\\___|\\__|          |_/                                                
"""),
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