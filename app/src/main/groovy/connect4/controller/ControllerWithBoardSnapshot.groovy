package connect4.controller

import connect4.model.Color
import groovy.transform.InheritConstructors

@InheritConstructors
abstract class ControllerWithBoardSnapshot extends Controller {
    Color[][] getBoardSnapshot() {
        return this.game.boardSnapshot
    }
}
