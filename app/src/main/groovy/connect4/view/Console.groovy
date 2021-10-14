package connect4.view

import connect4.model.Coordinate
import connect4.model.NullCoordinate
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import org.codehaus.groovy.runtime.StringGroovyMethods
import org.fusesource.jansi.Ansi

@Singleton(lazy = true)
class Console {
    void writeLn(String message) {
        println(Ansi.ansi().render(message))
    }

    void write(String message) {
        print(Ansi.ansi().render(message))
    }

    void writeLnAndWait(String message, Integer seconds) {
        this.writeLn(message)
        this.wait(seconds)
    }

    void writeAndWait(String message, Integer seconds) {
        this.write(message)
        this.wait(seconds)
    }

    private void wait(Integer seconds) {
        Thread.sleep(seconds * 1000)
    }

    void clear() {
        print(Ansi.ansi().eraseScreen().cursor(0,0))
    }

    void showTable(Object[][] objects) {
        AsciiTable table = new AsciiTable()
        table.addRule()
        objects.each { Object[] row ->
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRow(row)
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRule()
        }
        writeLn(table.render())
    }

    void writeLn(Object object) {
        this.writeLn(object.toString())
    }

    boolean askBoolean(String message) {
        Scanner scanner = new Scanner(System.in)
        this.writeLn("$message [y/n]")
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
        this.writeLn(message)
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
