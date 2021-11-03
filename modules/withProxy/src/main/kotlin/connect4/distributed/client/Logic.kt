package connect4.distributed.client

import connect4.common.controller.PlayController
import connect4.common.controller.ResumeController
import connect4.common.controller.StartController
import connect4.common.controller.Logic as CommonLogic
import connect4.common.model.StateValue


class Logic(private val tcpService: TCPService): CommonLogic(SessionProxy(tcpService)) {
    init {
        controllers[StateValue.START] = StartController(this.session)
        controllers[StateValue.PLAY] = PlayController(this.session)
        controllers[StateValue.RESUME] = ResumeController(this.session)
    }

    fun close() {
        this.tcpService.close()
    }
}