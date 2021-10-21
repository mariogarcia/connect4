package connect4.common.controller

import connect4.common.model.Color
import connect4.common.model.Session

abstract class StartController(private val session: Session): Controller(session), VisitorAwareController {
    abstract fun reset()
    abstract fun getBoardColors(): List<Array<Color>>
    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}