package connect4

import connect4.controller.Controller
import connect4.controller.Logic
import connect4.view.GameView
import connect4.view.View

class Connect4 {
    var view: View = GameView()
    var logic: Logic = Logic()

    fun play() {
        var controller: Controller?
        do {
            controller = logic.getController()
            controller?.accept(this.view)
        } while(controller != null)
    }
}

fun main() {
    Connect4().play()
}
