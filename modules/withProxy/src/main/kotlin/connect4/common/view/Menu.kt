package connect4.common.view


abstract class Menu(private val console: Console) {
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
            console.writeLn(Messages.MENU_OPTION_CHOOSE)
            commandsToShow.forEachIndexed { i: Int, cmd: Command -> console.writeLn("${i + 1}) ${cmd.getTitle()}") }

            option = console.askInt("> ") - 1
            error = !(0 until commands.size).contains(option)
        } while (error)

        commandsToShow[option].execute()
    }
}