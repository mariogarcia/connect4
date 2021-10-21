package connect4.distributed.client

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player
import connect4.common.model.Session as CommonSession
import connect4.common.controller.PlayController as CommonPlayController

class PlayController(session: CommonSession): CommonPlayController(session) {
    override fun playWithCoordinate(coordinate: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun isConnect4(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isValidCoordinate(coordinate: Coordinate): Boolean {
        TODO("Not yet implemented")
    }

    override fun getRandomCoordinate(): Coordinate {
        TODO("Not yet implemented")
    }

    override fun getCurrentPlayer(): Player {
        TODO("Not yet implemented")
    }

    override fun getBoardSnapshot(): List<Array<Color>> {
        TODO("Not yet implemented")
    }

    override fun redo() {
        TODO("Not yet implemented")
    }

    override fun isRedoable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun undo() {
        TODO("Not yet implemented")
    }

    override fun isUndoable(): Boolean {
        TODO("Not yet implemented")
    }

    override fun nextState() {
        TODO("Not yet implemented")
    }
}