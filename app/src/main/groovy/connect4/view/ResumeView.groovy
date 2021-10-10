package connect4.view

import connect4.i18n.Messages
import groovy.transform.InheritConstructors

@InheritConstructors
class ResumeView extends ConsoleView {
    boolean resume() {
        return this.renderer.askBoolean(Messages.NEW_GAME_QUESTION.toString())
    }
}
