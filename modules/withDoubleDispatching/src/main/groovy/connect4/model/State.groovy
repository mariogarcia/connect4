package connect4.model

class State {
    private StateValue value

    State() {
        this.reset()
    }

    void reset() {
        this.value = StateValue.START
    }

    void next() {
        this.value = StateValue.safeIndexAccessValues()[this.value.ordinal() + 1]
    }

    StateValue getValue() {
        return this.value
    }
}
