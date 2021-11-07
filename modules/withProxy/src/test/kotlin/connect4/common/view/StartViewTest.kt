package connect4.common.view

import connect4.common.controller.StartController
import connect4.test.MockitoHelper.anyObject
import connect4.test.View
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

@View
class StartViewTest: ViewTest<StartController, StartView>() {
    override fun createView(): StartView = StartView()
    override fun getControllerClass(): Class<StartController> = StartController::class.java

    @Test
    fun `when start view is shown, controller is reset`() {
        view.show(controller, console)
        verify(controller, times(1)).reset()
    }

    @Test
    fun `when start view is shown, console is clear`() {
        view.show(controller, console)
        verify(console, times(1)).clear()
    }

    @Test
    fun `when start view is shown, console says hi`() {
        view.show(controller, console)
        verify(console, times(1)).writeLn(anyObject())
    }

    @Test
    fun `when start view is shown, console shows the game table`() {
        view.show(controller, console)
        verify(controller, times(1)).getBoardColors()
        verify(console, times(1)).showTable(anyObject())
    }

    @Test
    fun `when start view is shown, controller asks for the next state`() {
        view.show(controller, console)
        verify(controller, times(1)).nextState()
    }
}