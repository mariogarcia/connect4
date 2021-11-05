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
        with(Game()) {
            assertEquals(Color.RED, getCurrentPlayer().color)
        }
    }

    @Test
    fun `given a new game, when toggling player, the turn is for player BLUE`() {
        with(Game()) {
            togglePlayer()
            assertEquals(Color.BLUE, getCurrentPlayer().color)
        }
    }

    @Test
    fun `given a game, when asking if an coordinate outside the bounds is valid, it will return false`() {
        with(Game()) {
            assertFalse(isValidCoordinate(Coordinate(-1, -1)))
        }
    }

    @Test
    fun `given a game, when asking if a coordinate already used is valid, it will return false`() {
        with(Game()) {
            playWithCoordinate(Coordinate(0, 0))
            assertFalse(isValidCoordinate(Coordinate(0,0)))
        }
    }

    @Test
    fun `given a game, when asking if a valid coordinate is valid, it will return true`() {
        with(Game()) {
            assertTrue(isValidCoordinate(Coordinate(0,0)))
        }
    }
}