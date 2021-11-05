package connect4.common.model

import connect4.test.Fast
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@Fast
class GameTest {
    @Test
    fun `given a new game, upfront there is no connect4`() {
        assertFalse(Game().isConnect4())
    }

    @Test
    fun `given a new game, the first turn is for player RED`() {
        val game = Game()
        assertEquals(Color.RED, game.getCurrentPlayer().color)
    }

    @Test
    fun `given a new game, when toggling player, the turn is for player BLUE`() {
        val game = Game()
        game.togglePlayer()
        assertEquals(Color.BLUE, game.getCurrentPlayer().color)
    }

    @Test
    fun `given a game, when asking if an coordinate outside the bounds is valid, it will return false`() {
        val game = Game()
        assertFalse(game.isValidCoordinate(Coordinate(-1, -1)))
    }

    @Test
    fun `given a game, when asking if a coordinate already used is valid, it will return false`() {
        val game = Game()
        game.playWithCoordinate(Coordinate(0, 0))
        assertFalse(game.isValidCoordinate(Coordinate(0,0)))
    }

    @Test
    fun `given a game, when asking if a valid coordinate is valid, it will return true`() {
        val game = Game()
        assertTrue(game.isValidCoordinate(Coordinate(0,0)))
    }
}