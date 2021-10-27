package connect4.common.controller

import connect4.common.model.Session

class ResumeController(private val session: Session):  Controller(session), VisitorAwareController {
    fun reset() {
        this.session.reset()
    }

    override fun nextState() {
        this.session.next()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}