package connect4.common.controller

import connect4.common.controller.PlayController
import connect4.common.controller.ResumeController
import connect4.common.controller.StartController

interface ControllersVisitor {
    fun visit(startController: StartController)
    fun visit(playController: PlayController)
    fun visit(resumeController: ResumeController): Boolean
}