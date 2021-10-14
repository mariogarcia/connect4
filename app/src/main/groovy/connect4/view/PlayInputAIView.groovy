package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

class PlayInputAIView extends PlayInputView {
    @Override
    Coordinate getCoordinate(PlayController controller) {
        Coordinate coordinate

        do {
            String question = Messages.NEXT_MOVE_QUESTION.format(controller.currentPlayer.color)
            ConsoleRenderer.instance.show(question)
            ConsoleRenderer.instance.show(Messages.nextAISentence())
            Thread.sleep(5000)

            coordinate = controller.getRandomCoordinate()
        } while (!controller.isValidCoordinate(coordinate))

        return coordinate
    }
}
