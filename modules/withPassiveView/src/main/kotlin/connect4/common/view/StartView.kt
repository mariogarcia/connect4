package connect4.common.view

interface StartView<out O> {
    fun render(message: String): O
}