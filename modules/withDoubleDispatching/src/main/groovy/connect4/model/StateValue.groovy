package connect4.model

enum StateValue {
    START, PLAY, RESUME, GOODBYE

    static List<StateValue> safeIndexAccessValues() {
        return values().toList()
    }
}