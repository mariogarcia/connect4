package connect4.model

enum class Color: Nullable {
    RED,
    BLUE,
    NULL {
        override fun isNull(): Boolean = true
    }
}