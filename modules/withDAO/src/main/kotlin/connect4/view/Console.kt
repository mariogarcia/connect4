package connect4.view

import connect4.model.Color
import connect4.model.Coordinate
import connect4.model.NullCoordinate
import de.vandermeer.asciitable.AsciiTable
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment
import org.fusesource.jansi.Ansi
import java.lang.NumberFormatException
import java.util.*

object Console {
    fun write(message: String) {
        print(Ansi.ansi().render(message))
    }

    fun writeLn(message: Any) {
        this.writeLn(message.toString())
    }

    private fun writeLn(message: String) {
        println(Ansi.ansi().render(message))
    }

    fun writeAndWait(message: String, seconds: Long) {
        this.write(message)
        this.waitSeconds(seconds)
    }

    fun writeLnAndWait(message: String, seconds: Long) {
        this.writeLn(message)
        this.waitSeconds(seconds)
    }

    private fun waitSeconds(seconds: Long) {
        Thread.sleep(seconds * 1000)
    }

    fun clear() {
        print(Ansi.ansi().eraseScreen().cursor(0, 0))
    }

    fun showTable(cells: List<Array<Color>>) {
        val table = AsciiTable()
        table.addRule()
        cells.forEach { row: Array<Color> ->
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRow(row.toList())
            table.setPadding(1).setTextAlignment(TextAlignment.CENTER).addRule()
        }
        writeLn(table.render())
    }

    fun askBoolean(message: String): Boolean {
        val scanner = Scanner(System.`in`)

        this.writeLn("$message [y/n]")

        var response: String
        var isCorrect: Boolean

        do {
            response = scanner.next(".").trim().toLowerCase()
            isCorrect = response.matches("[yn]".toRegex())
        } while(!isCorrect)

        return response == "y"
    }

    fun askInt(message: String): Int {
        val scanner = Scanner(System.`in`)
        this.write(message)
        return scanner.nextInt()
    }

    fun askCoordinate(message: String): Coordinate {
        val scanner = Scanner(System.`in`)
        this.write(message)
        return this.fromString(scanner.nextLine())
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