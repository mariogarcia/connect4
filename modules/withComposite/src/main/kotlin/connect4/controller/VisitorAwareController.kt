package connect4.controller

interface VisitorAwareController {
    fun accept(visitor: ControllersVisitor)
}