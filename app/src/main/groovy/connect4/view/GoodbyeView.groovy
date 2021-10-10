package connect4.view

import connect4.controller.GoodbyeController
import connect4.i18n.Messages

class GoodbyeView {
    void show(GoodbyeController goodbyeController) {
        ConsoleRenderer.instance.show(Messages.GOOD_BYE)
        goodbyeController.nextState()
    }
}
