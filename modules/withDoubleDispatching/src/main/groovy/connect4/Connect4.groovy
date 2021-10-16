package connect4

import connect4.controller.Controller
import connect4.controller.Logic
import connect4.view.GameView
import connect4.view.View

class Connect4 {
    private View view = new GameView()
    private Logic logic = new Logic()

    void play() {
        Controller controller
        do {
            controller = logic.controller
            controller?.accept(this.view)
        } while(controller)
    }

    static void main(String[] args) {
        new Connect4().play()
    }
}
