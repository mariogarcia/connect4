package connect4.common.view

import connect4.common.controller.PlayController

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