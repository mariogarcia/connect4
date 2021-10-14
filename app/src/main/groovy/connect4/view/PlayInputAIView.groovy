package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

class PlayInputAIView extends PlayInputView {
    @Override
    Coordinate getCoordinate(PlayController controller) {
        Coordinate coordinate

        do {
            String question = Messages.NEXT_MOVE_QUESTION.format(controller.currentPlayer.color)

            Console.instance.writeAndWait(question, 2)
            Console.instance.writeLnAndWait(Messages.nextAISentence(), 5)

            coordinate = controller.getRandomCoordinate()
        } while (!controller.isValidCoordinate(coordinate))

        return coordinate
    }
}
