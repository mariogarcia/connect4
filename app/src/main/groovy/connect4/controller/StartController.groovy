package connect4.controller

import groovy.transform.InheritConstructors

@InheritConstructors
class StartController extends ControllerWithBoardSnapshot {
    void reset() {
        this.game.reset()
    }

    @Override
    void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this)
    }
}
