package connect4.distributed.client

import connect4.common.controller.Logic as CommonLogic
import connect4.common.Connect4 as CommonConnect4

class Connect4Client: CommonConnect4() {
    private var logicProxy = Logic(TCPService())

    override fun createLogic(): CommonLogic {
        return this.logicProxy
    }

    override fun play() {
        super.play()
        this.logicProxy.close()
    }
}

fun main() {
    Connect4Client().play()
}