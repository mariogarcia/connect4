package connect4.controller

import connect4.model.Color

class StartController(private val session: Session): Controller(session), VisitorAwareController {
    fun reset() {
        this.session.reset()
    }

    fun getBoardSnapshot(): List<Array<Color>> {
        return this.session.getBoardSnapshot()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}