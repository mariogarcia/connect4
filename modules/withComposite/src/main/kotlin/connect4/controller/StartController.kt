package connect4.controller

class StartController(private val session: Session): BoardController(session) {
    fun reset() {
        this.session.reset()
    }

    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}