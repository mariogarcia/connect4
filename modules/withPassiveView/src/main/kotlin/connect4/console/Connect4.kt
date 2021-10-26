package connect4.console

import connect4.common.Connect4
import connect4.console.view.ConsoleViewFactory
import connect4.common.view.ViewFactory

class ConsoleConnect4: Connect4() {
    override fun createViewFactory(): ViewFactory = ConsoleViewFactory
}

fun main() {
    ConsoleConnect4().play()
}