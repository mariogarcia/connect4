package connect4.common

import connect4.common.controller.Logic
import connect4.common.controller.VisitorAwareController
import connect4.common.view.GameView
import connect4.common.view.View

abstract class Connect4 {
    var view: View = GameView()

    open fun play() {
        var logic: Logic = this.createLogic()
        var controller: VisitorAwareController?
        do {
            controller = logic.getController()
            controller?.accept(this.view)
        } while(controller != null)
    }

    abstract fun createLogic(): Logic
}