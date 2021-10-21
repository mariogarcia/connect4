package connect4.distributed.client

import connect4.common.controller.Logic
import connect4.common.Connect4 as CommonConnect4

class Connect4Client: CommonConnect4() {
    override fun createLogic(): Logic {
        TODO("Not yet implemented")
    }

    override fun play() {
        super.play()
    }
}

fun main() {
    Connect4Client().play()
}