package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.model.Coordinate
import connect4.common.view.Messages.Companion.format

class PlayInputAIView: PlayInputView {
    override fun getCoordinate(controller: PlayController, console: Console): Coordinate {
        var coordinate: Coordinate
        do {
            val color = controller.getCurrentPlayer().color.toString()
            val question = Messages.NEXT_MOVE_QUESTION.format(color)

            console.writeAndWait(question, 2)
            console.writeLnAndWait(Messages.nextAISentence(), 5)

            coordinate = controller.getRandomCoordinate()
        } while (!controller.isValidCoordinate(coordinate))
        return coordinate
    }
}