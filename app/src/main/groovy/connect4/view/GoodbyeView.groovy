package connect4.view

import connect4.controller.GoodbyeController

class GoodbyeView {
    void show(GoodbyeController goodbyeController) {
        ConsoleRenderer.instance.show(Messages.GOOD_BYE)
        goodbyeController.nextState()
    }
}
