package connect4.common.view

object ConsoleFactory {
    private val console = DefaultConsole()
    fun getConsoleInstance(): Console = console
}