package connect4.common.view

import connect4.common.controller.StartController
import connect4.test.MockitoHelper.anyObject
import connect4.test.MockInitializer
import connect4.test.View
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*

@View
class StartViewTest: MockInitializer() {
    @Mock
    private lateinit var console: Console

    @Mock
    private lateinit var controller: StartController

    @InjectMocks
    private lateinit var view: StartView

    @Test
    fun `when start view is shown, a certain interactions are expected`() {
        view.show(controller, console)

        with(inOrder(console, controller)) {
            verify(controller, times(1)).reset()
            verify(console, times(1)).clear()
            verify(console, times(1)).writeLn(anyObject())
            verify(controller, times(1)).getBoardColors()
            verify(console, times(1)).showTable(anyObject())
            verify(controller, times(1)).nextState()
        }
    }
}