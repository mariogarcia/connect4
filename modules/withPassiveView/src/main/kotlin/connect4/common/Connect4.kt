package connect4.common

import connect4.console.controller.PlayController
import connect4.console.controller.ResumeController
import connect4.console.controller.StartController
import connect4.common.model.Session
import connect4.common.view.ViewFactory

abstract class Connect4 {
    fun play() {
        val session = Session()
        val viewFactory = createViewFactory()

        val startController = StartController(session, viewFactory)
        val playController = PlayController(session, viewFactory)
        val resumeController = ResumeController(session, viewFactory)

        do {
            startController.control()
            playController.control()
        } while (resumeController.control())
    }

    abstract fun createViewFactory(): ViewFactory
}
