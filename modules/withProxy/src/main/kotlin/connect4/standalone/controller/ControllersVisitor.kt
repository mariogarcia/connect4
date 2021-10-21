package connect4.standalone.controller

interface ControllersVisitor {
    fun visit(startController: StartController)
    fun visit(playController: PlayController)
    fun visit(resumeController: ResumeController): Boolean
}