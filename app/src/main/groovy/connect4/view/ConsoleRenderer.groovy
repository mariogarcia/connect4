package connect4.view

import connect4.model.Coordinate
import connect4.model.NullCoordinate
import org.codehaus.groovy.runtime.StringGroovyMethods

class ConsoleRenderer {
    private static ConsoleRenderer INSTANCE
    private ConsoleRenderer() {}

    static ConsoleRenderer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConsoleRenderer()
        }
        return INSTANCE
    }

    void show(String message) {
        println message
    }

    void show(Object object) {
        this.show(object.toString())
    }

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

    Coordinate askCoordinate(String message) {
        Scanner scanner = new Scanner(System.in)
        this.show(message)
        return this.fromString(scanner.nextLine())
    }

    private Coordinate fromString(String input) {
        List<Integer> rowCol = input
                .split(",")
                .findAll(StringGroovyMethods::isNumber)
                .collect(Integer::parseInt)

        if (rowCol.size() == 2) {
            return new Coordinate(rowCol.first(), rowCol.last())
        }

        return new NullCoordinate()
    }
}
