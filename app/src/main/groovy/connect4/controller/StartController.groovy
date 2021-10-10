package connect4.controller

import groovy.transform.InheritConstructors

@InheritConstructors
class StartController extends Controller {
    void reset() {
        this.game.reset()
    }
}
