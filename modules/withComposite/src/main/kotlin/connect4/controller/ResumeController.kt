package connect4.controller

class ResumeController(private val session: Session): Controller(session) {
    fun reset() {
        this.session.reset()
    }
    override fun accept(visitor: ControllersVisitor) {
        visitor.visit(this)
    }
}
