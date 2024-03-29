package connect4.common.view

import connect4.common.controller.PlayController

abstract class Command(private val title: String, protected val controller: PlayController) {
    abstract fun isActive(): Boolean
    abstract fun execute(console: Console)

    fun getTitle(): String {
        return this.title
    }
}