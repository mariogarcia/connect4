package connect4.common.controller

import connect4.common.controller.Controller
import connect4.common.controller.ControllersVisitor
import connect4.common.controller.VisitorAwareController
import connect4.common.model.Color
import connect4.common.model.Session
import connect4.common.controller.StartController as CommonStartController

class StartController(private val session: Session): Controller(session), VisitorAwareController {
    fun reset() {
        this.session.reset()
    }

    fun getBoardColors(): List<Array<Color>> {
        return this.session.getBoardColors()
    }

    override fun nextState() {
        this.session.next()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}