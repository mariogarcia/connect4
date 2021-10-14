package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

class PlayInputAIView extends PlayInputView {
    @Override
    Coordinate getCoordinate(PlayController controller) {
        String question = Messages.NEXT_MOVE_QUESTION.format(controller.currentPlayer.color)
        Coordinate coordinate

        do {
            ConsoleRenderer.instance.show(question)
            coordinate = controller.getRandomCoordinate()
        } while (!controller.isValidCoordinate(coordinate))

        return coordinate
    }
}
