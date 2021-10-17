package connect4.view.play

import connect4.controller.PlayController
import connect4.view.Console

abstract class Command(private val title: String, protected val controller: PlayController) {
    abstract fun isActive(): Boolean
    abstract fun execute()

    fun getTitle(): String {
        return this.title
    }

    fun showBoard() {
        Console.clear()
        Console.showTable(controller.getBoardSnapshot())
    }
}