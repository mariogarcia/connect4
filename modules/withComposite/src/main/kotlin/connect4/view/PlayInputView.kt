package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

interface PlayInputView {
    abstract fun getCoordinate(controller: PlayController): Coordinate
}