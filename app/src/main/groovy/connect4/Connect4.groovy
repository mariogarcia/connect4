package connect4

import connect4.controller.Controller
import connect4.controller.Logic
import connect4.controller.PlayController
import connect4.controller.ResumeController
import connect4.controller.StartController
import connect4.view.GameView
import connect4.view.View

class Connect4 {
    private View view
    private Logic logic

    Connect4() {
        this.view = new GameView()
        this.logic = new Logic()
    }

    void play() {
        Controller controller
        do {
            controller = logic.controller
            if (controller instanceof StartController) {
                this.view.start((StartController) controller)
            } else if (controller instanceof PlayController) {
                this.view.play((PlayController) controller)
            } else {
                this.view.resume((ResumeController) controller)
            }
        } while (logic.controller)
    }

    static void main(String[] args) {
        new Connect4().play()
    }
}
