package connect4.view

import connect4.i18n.Messages
import groovy.transform.InheritConstructors

@InheritConstructors
class GoodbyeView extends ConsoleView {
    void show() {
        this.renderer.show(Messages.GOOD_BYE)
    }
}
