package connect4.standalone

import connect4.common.Connect4 as CommonConnect4
import connect4.common.controller.Logic as CommonLogic

class Connect4: CommonConnect4() {
    override fun createLogic(): CommonLogic {
        return Logic(Session())
    }
}

fun main() {
    Connect4().play()
}