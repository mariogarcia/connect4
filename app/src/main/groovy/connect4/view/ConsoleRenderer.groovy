package connect4.view

class ConsoleRenderer implements Renderer {
    @Override
    void show(String message) {
        println message
    }

    @Override
    void show(Object object) {
        this.show(object.toString())
    }

    @Override
    boolean askBoolean(String message) {
        Scanner scanner = new Scanner(System.in)
        this.show("$message [y/n]")
        String response
        boolean isCorrect

        do {
            response = scanner.next(/./).trim().toLowerCase()
            isCorrect = response ==~ /y|n/
        } while (!isCorrect)

        return response == "y"
    }

    @Override
    def <T> T ask(String message, InputMapper<T> mapper) {
        Scanner scanner = new Scanner(System.in)
        this.show(message)
        return mapper.fromString(scanner.nextLine())
    }
}
