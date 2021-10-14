package connect4.view

import connect4.controller.StartController

class StartView  {
    BoardView boardView

    StartView() {
        this.boardView = new BoardView()
    }

    void show(StartController startController) {
        startController.reset()
        Console.instance.show(Messages.GREETINGS)
        this.boardView.show(startController)
        startController.nextState()
    }
}
