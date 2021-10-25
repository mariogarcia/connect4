package connect4

import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController
import connect4.model.Session

class Connect4 {
    fun play() {
        val session = Session()
        val startController = StartController(session)
        val playController = PlayController(session)
        val resumeController = ResumeController(session)

        do {
            startController.control()
            playController.control()
        } while (resumeController.control())
    }
}

fun main() {
    Connect4().play()
}
