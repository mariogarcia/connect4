package connect4.standalone.view

import connect4.standalone.controller.PlayController
import connect4.common.model.Coordinate

interface PlayInputView {
    fun getCoordinate(controller: PlayController): Coordinate
}