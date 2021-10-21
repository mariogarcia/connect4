package connect4.common.controller

import connect4.common.model.Session
import connect4.common.model.StateValue

abstract class Logic(protected val session: Session) {
    protected val controllers: MutableMap<StateValue, VisitorAwareController> = mutableMapOf()

    fun getController(): VisitorAwareController? {
        return this.controllers[this.session.getStateValue()]
    }
}