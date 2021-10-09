package connect4.view

class ConsoleRenderer implements Renderer {
    @Override
    void writeln(String message) {
        println message
    }

    @Override
    void writeln(Object object) {
        this.writeln(object.toString())
    }

    @Override
    boolean askBoolean(String message) {
        Scanner scanner = new Scanner(System.in)
        this.writeln("$message [y/n]")
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
        this.writeln(message)
        return mapper.fromString(scanner.nextLine())
    }
}
