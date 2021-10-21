package connect4.distributed.client

import connect4.common.model.Color
import connect4.common.model.Session as CommonSession
import connect4.common.controller.StartController as CommonStartController

class StartController(session: CommonSession): CommonStartController(session) {
    override fun reset() {
        TODO("Not yet implemented")
    }

    override fun getBoardColors(): List<Array<Color>> {
        TODO("Not yet implemented")
    }

    override fun nextState() {
        TODO("Not yet implemented")
    }
}