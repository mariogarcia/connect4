package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.model.Coordinate

interface PlayInputView {
    fun getCoordinate(controller: PlayController, console: Console): Coordinate
}