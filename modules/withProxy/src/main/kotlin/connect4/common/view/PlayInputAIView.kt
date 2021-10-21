package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.model.Coordinate
import connect4.common.view.Messages.Companion.format

class PlayInputAIView: PlayInputView {
    override fun getCoordinate(controller: PlayController): Coordinate {
        var coordinate: Coordinate
        do {
            val color = controller.getCurrentPlayer().color.toString()
            val question = Messages.NEXT_MOVE_QUESTION.format(color)

            Console.writeAndWait(question, 2)
            Console.writeLnAndWait(Messages.nextAISentence(), 5)

            coordinate = controller.getRandomCoordinate()
        } while (!controller.isValidCoordinate(coordinate))
        return coordinate
    }
}