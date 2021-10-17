package connect4.view.play

import connect4.controller.PlayController
import connect4.model.Coordinate

interface PlayInputView {
    fun getCoordinate(controller: PlayController): Coordinate
}