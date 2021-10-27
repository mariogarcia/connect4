package connect4.distributed.client.model

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.Player
import connect4.common.model.StateValue
import connect4.common.model.Session as CommonSession

class SessionProxy(private val tcpService: TCPService): CommonSession {
    override fun getStateValue(): StateValue {
        TODO("Not yet implemented")
    }

    override fun next() {
        TODO("Not yet implemented")
    }

    override fun getBoardColors(): List<Array<Color>> {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }

    override fun playWithCoordinate(coordinate: Coordinate) {
        TODO("Not yet implemented")
    }

    override fun isConnect4(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isValidCoordinate(coordinate: Coordinate): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCurrentPlayer(): Player {
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

}