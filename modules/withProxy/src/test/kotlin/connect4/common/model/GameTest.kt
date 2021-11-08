package connect4.common.model

import connect4.test.Fast
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@Fast
class GameTest {
    private lateinit var game: Game

    @BeforeEach
    fun init() {
        this.game = Game()
    }

    @Test
    fun `given a new game, upfront there is no connect4`() {
        assertFalse(this.game.isConnect4())
    }

    @Test
    fun `given a new game, the first turn is for player RED`() {
        assertEquals(Color.RED, this.game.getCurrentPlayer().color)
    }

    @Test
    fun `given a new game, when toggling player, the turn is for player BLUE`() {
        game.togglePlayer()
        assertEquals(Color.BLUE, this.game.getCurrentPlayer().color)
    }

    @Test
    fun `given a game, when asking if an coordinate outside the bounds is valid, it will return false`() {
        assertFalse(this.game.isValidCoordinate(Coordinate(-1, -1)))
    }

    @Test
    fun `given a game, when asking if a coordinate already used is valid, it will return false`() {
        this.game.playWithCoordinate(Coordinate(0, 0))
        assertFalse(this.game.isValidCoordinate(Coordinate(0,0)))
    }

    @Test
    fun `given a game, when asking if a valid coordinate is valid, it will return true`() {
        assertTrue(this.game.isValidCoordinate(Coordinate(0,0)))
    }
}