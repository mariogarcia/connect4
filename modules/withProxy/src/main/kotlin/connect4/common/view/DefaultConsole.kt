package connect4.common.view

import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.NullCoordinate
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import org.fusesource.jansi.Ansi
import java.lang.NumberFormatException
import java.util.*

class DefaultConsole: Console {
    override fun write(message: String) {
        print(Ansi.ansi().render(message))
    }

    override fun writeLn(message: Any) {
        writeLn(message.toString())
    }

    private fun writeLn(message: String) {
        println(Ansi.ansi().render(message))
    }

    override fun writeAndWait(message: String, seconds: Long) {
        write(message)
        waitSeconds(seconds)
    }

    override fun writeLnAndWait(message: String, seconds: Long) {
        writeLn(message)
        waitSeconds(seconds)
    }

    private fun waitSeconds(seconds: Long) {
        Thread.sleep(seconds * 1000)
    }

    override fun clear() {
        print(Ansi.ansi().eraseScreen().cursor(0, 0))
    }

    override fun showTable(cells: List<Array<Color>>) {
        val table = AsciiTable()
        table.addRule()
        cells.forEach { row: Array<Color> ->
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRow(row.toList())
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRule()
        }
        writeLn(table.render())
    }

    override fun askBoolean(message: String): Boolean {
        val scanner = Scanner(System.`in`)

        writeLn("$message [y/n]")

        var response: String
        var isCorrect: Boolean

        do {
            response = scanner.next(".").trim().toLowerCase()
            isCorrect = response.matches("[yn]".toRegex())
        } while(!isCorrect)

        return response == "y"
    }

    override fun askInt(message: String): Int {
        val scanner = Scanner(System.`in`)
        write(message)
        return scanner.nextInt()
    }

    override fun askCoordinate(message: String): Coordinate {
        val scanner = Scanner(System.`in`)
        write(message)
        return fromString(scanner.nextLine())
    }

    private fun fromString(input: String): Coordinate {
        val rowCol: List<Int> = input.split(",").mapNotNull { it.toIntOrNull() }

        return if (rowCol.size != 2) NullCoordinate() else Coordinate(rowCol.first(), rowCol.last())
    }

    private fun String.toIntOrNull() = try {
        toInt()
    } catch (e: NumberFormatException) {
        null
    }
}