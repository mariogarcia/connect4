package connect4.common.view

import connect4.common.controller.PlayController
import connect4.common.model.AIPlayer
import connect4.common.model.Color
import connect4.common.model.Coordinate
import connect4.common.model.HumanPlayer
import connect4.test.MockitoHelper.anyObject
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.openMocks

class ActionCommandTest {
    @Mock
    private lateinit var controller: PlayController

    @Mock
    private lateinit var console: Console

    @InjectMocks
    private lateinit var command: ActionCommand

    @BeforeEach
    fun init() {
        openMocks(this)
    }

    @Test
    fun `when the current player is human, the player is asked for a coordinate`() {
        `when`(controller.getCurrentPlayer()).thenReturn(HumanPlayer(Color.BLUE))
        `when`(console.askCoordinate(anyString())).thenReturn(Coordinate(0,0))
        `when`(controller.isValidCoordinate(anyObject())).thenReturn(true)

        command.execute(console)

        with(inOrder(console, controller)) {
            verify(console, times(1)).askCoordinate(anyString())
            verify(controller, times(1)).playWithCoordinate(anyObject())
            verify(console, times(1)).showTable(anyObject())
        }
    }

    @Test
    fun `when the current player is an AI, the controller gives a random coordinate`() {
        `when`(controller.getCurrentPlayer()).thenReturn(AIPlayer(Color.RED))
        `when`(controller.getRandomCoordinate()).thenReturn(Coordinate(0, 0))
        `when`(controller.isValidCoordinate(anyObject())).thenReturn(true)

        command.execute(console)

        with(inOrder(console, controller)) {
            verify(controller, times(1)).getRandomCoordinate()
            verify(controller, times(1)).playWithCoordinate(anyObject())
            verify(console, times(1)).showTable(anyObject())
        }
    }
}