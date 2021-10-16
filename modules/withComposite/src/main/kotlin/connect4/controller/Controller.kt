package connect4.controller

abstract class Controller(private val session: Session) {
    fun nextState() {
        this.session.next()
    }
}