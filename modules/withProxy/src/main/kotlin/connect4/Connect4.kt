package connect4

import connect4.standalone.controller.Logic
import connect4.standalone.controller.VisitorAwareController
import connect4.standalone.view.GameView
import connect4.standalone.view.View

open abstract class Connect4 {
    var view: View = GameView()

    fun play() {
        var logic: Logic = this.createLogic()
        var controller: VisitorAwareController?
        do {
            controller = logic.getController()
            controller?.accept(this.view)
        } while(controller != null)
    }

    abstract fun createLogic(): Logic
}