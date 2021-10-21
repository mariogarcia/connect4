package connect4

import connect4.standalone.controller.implementation.Logic
import connect4.standalone.controller.Logic as AbstractLogic

class Connect4Standalone: Connect4() {
    override fun createLogic(): AbstractLogic {
        return Logic()
    }
}

fun main() {
    Connect4Standalone().play()
}