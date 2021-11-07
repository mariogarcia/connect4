package connect4.standalone

import connect4.common.model.Color
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

class SessionTest {
    @Test
    fun `given a new session, there should be 7x6 cells with NULL color`() {
        val session = Session()
        val rows: List<Array<Color>> = session.getBoardColors()

        assertThat(rows.size, equalTo(7))
        assertThat(rows, everyItem(arrayWithSize(6)))
        assertThat(getCellList(rows), everyItem(`is`(Color.NULL)))
    }

    private fun getCellList(board: List<Array<Color>>) = board.flatMap { it.toList() }
}