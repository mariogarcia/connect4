package connect4.view

import connect4.controller.StartController

class StartView  {
    BoardView boardView
    GreetingsView greetingsView

    StartView() {
        this.boardView = new BoardView()
        this.greetingsView = new GreetingsView()
    }

    void show(StartController startController) {
        startController.reset()
        this.greetingsView.show()
        this.boardView.show(startController)
        startController.nextState()
    }
}
