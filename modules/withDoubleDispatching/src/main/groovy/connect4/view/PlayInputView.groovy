package connect4.view

import connect4.controller.PlayController
import connect4.model.Coordinate

abstract class PlayInputView {
    abstract Coordinate getCoordinate(PlayController controller)
}
