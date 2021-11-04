package connect4.common.model

import connect4.common.test.Fast
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

@Fast
class GameTest {
    @Test
    fun `given a new game, upfront there is no connect4`() {
        val newGame = Game()
        assertFalse(newGame.isConnect4())
    }

    @Test
    fun `given a new game, the first turn is for player RED`() {
        val newGame = Game()
        val firstTurn = newGame.getCurrentPlayer()
        assertEquals(Color.RED, firstTurn.color)
    }
}