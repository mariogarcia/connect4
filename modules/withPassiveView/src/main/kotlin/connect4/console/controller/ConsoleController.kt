package connect4.console.controller

import connect4.common.controller.Controller
import connect4.common.model.Session
import connect4.common.view.ViewFactory

abstract class ConsoleController(protected val session: Session, protected val viewFactory: ViewFactory): Controller(session){
}