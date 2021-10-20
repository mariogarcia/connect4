package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate
import connect4.view.Messages.Companion.format

class PlayInputHumanView: PlayInputView {
    override fun getCoordinate(controller: PlayController): Coordinate {
        val color = controller.getCurrentPlayer().color
        val question = Messages.NEXT_MOVE_QUESTION.format(color.toString())
        var coordinate: Coordinate

        do {
            coordinate = Console.askCoordinate(question)
        } while (!controller.isValidCoordinate(coordinate))

        return coordinate
    }
}