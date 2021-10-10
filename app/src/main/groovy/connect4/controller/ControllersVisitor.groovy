package connect4.controller

interface ControllersVisitor {
    void visit(StartController startController)
    void visit(PlayController playController)
    boolean visit(ResumeController resumeController)
}