package connect4.standalone.controller

interface VisitorAwareController {
    fun accept(visitor: ControllersVisitor)
}