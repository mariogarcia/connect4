package connect4.model

enum Color {
    RED,
    BLACK,
    NULL

    boolean isNull() {
        return this == NULL
    }
}