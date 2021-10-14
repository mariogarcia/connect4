package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

class PlayInputHumanView extends PlayInputView {
    @Override
    Coordinate getCoordinate(PlayController controller) {
        String question = Messages.NEXT_MOVE_QUESTION.format(controller.currentPlayer.color)
        Coordinate coordinate

        do {
            coordinate = Console.instance.askCoordinate(question)
        } while (!controller.isValidCoordinate(coordinate))

        return coordinate
    }
}
