package connect4.common.model

class State {
    var value: StateValue = StateValue.START
        private set


    fun reset() {
        this.value = StateValue.START
    }

    fun next() {
        this.value = StateValue.values()[this.value.ordinal + 1]
    }
}