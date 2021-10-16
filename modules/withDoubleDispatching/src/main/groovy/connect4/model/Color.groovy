package connect4.model

enum Color {
    RED,
    BLACK,
    NULL

    boolean isNull() {
        return this == NULL
    }

    String toString() {
        return this.isNull() ? "-" : this.name()
    }
}