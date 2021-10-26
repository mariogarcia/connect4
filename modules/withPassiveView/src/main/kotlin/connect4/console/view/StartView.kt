package connect4.console.view

class StartView {
    fun showBanner() {
        Console.clear()
        Console.writeLn(Messages.GREETINGS)
    }
}