package connect4.controller

import groovy.transform.InheritConstructors

@InheritConstructors
class ResumeController extends Controller {
    void reset() {
        this.game.reset();
        this.state.reset();
    }

    @Override
    void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this)
    }
}
