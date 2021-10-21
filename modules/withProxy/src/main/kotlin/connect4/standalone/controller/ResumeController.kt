package connect4.standalone.controller

import connect4.common.model.Session

abstract class ResumeController(private val session: Session): Controller(session), VisitorAwareController {
    abstract fun reset()
    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}
