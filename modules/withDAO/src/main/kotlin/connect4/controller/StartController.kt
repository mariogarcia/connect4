package connect4.controller

import connect4.model.Color
import connect4.model.Session

class StartController(private val session: Session): Controller(session), VisitorAwareController {
    fun reset() {
        this.session.reset()
    }

    fun getBoardColors(): List<Array<Color>> {
        return this.session.getBoardColors()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}