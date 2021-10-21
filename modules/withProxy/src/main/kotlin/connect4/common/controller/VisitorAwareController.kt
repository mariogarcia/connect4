package connect4.common.controller

import connect4.common.controller.ControllersVisitor

interface VisitorAwareController {
    fun accept(visitor: ControllersVisitor)
}