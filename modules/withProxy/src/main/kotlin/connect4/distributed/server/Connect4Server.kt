package connect4.distributed.server

import connect4.distributed.server.controller.Logic
import connect4.distributed.server.model.Session

class Connect4Server {
    private val logic: Logic = Logic(Session())

    init {

    }

    fun serve() {

    }
}

fun main() {
    Connect4Server().serve()
}