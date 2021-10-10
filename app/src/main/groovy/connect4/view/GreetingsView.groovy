package connect4.view

class GreetingsView {
    static final String BANNER = """
  _____                       __      ____
 / ___/__  ___  ___  ___ ____/ /_____/ / /
/ /__/ _ \\/ _ \\/ _ \\/ -_) __/ __/___/_  _/
\\___/\\___/_//_/_//_/\\__/\\__/\\__/     /_/  
"""

    void show() {
        ConsoleRenderer.instance.show(BANNER)
    }
}
