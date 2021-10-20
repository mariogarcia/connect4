package connect4.view.play

import connect4.view.Console
import connect4.view.Messages


abstract class Menu {
    private val commands: MutableList<Command> = mutableListOf()

    fun addCommand(command: Command) {
        this.commands.add(command)
    }

    open fun execute() {
        val commandsToShow = commands.filter(Command::isActive)
        assert(commandsToShow.isNotEmpty())

        var error: Boolean
        var option: Int

        do {
            Console.writeLn(Messages.MENU_OPTION_CHOOSE)
            commandsToShow.forEachIndexed { i: Int, cmd: Command -> Console.writeLn("${i + 1}) ${cmd.getTitle()}") }

            option = Console.askInt("> ") - 1
            error = !(0 until commands.size).contains(option)
        } while (error)

        commandsToShow[option].execute()
    }
}