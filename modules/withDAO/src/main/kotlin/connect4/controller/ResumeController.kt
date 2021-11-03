package connect4.controller

import connect4.model.Session

class ResumeController(private val session: Session): Controller(session), VisitorAwareController {
    fun reset() {
        this.session.reset()
    }
    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}
