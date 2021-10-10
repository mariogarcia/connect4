package connect4.view

import groovy.transform.InheritConstructors

@InheritConstructors
class GreetingsView extends ConsoleView {
    static final String BANNER = """
  _____                       __      ____
 / ___/__  ___  ___  ___ ____/ /_____/ / /
/ /__/ _ \\/ _ \\/ _ \\/ -_) __/ __/___/_  _/
\\___/\\___/_//_/_//_/\\__/\\__/\\__/     /_/  
"""

    void interact() {
        this.renderer.show(BANNER)
    }
}
