package connect4.controller

interface ControllersVisitor {
    fun visit(startController: StartController)
    fun visit(playController: PlayController)
    fun visit(resumeController: ResumeController): Boolean
}