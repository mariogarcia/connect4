package connect4.common.view

import connect4.common.controller.ResumeController
import connect4.test.View
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

@View
class ResumeViewTest: ViewTest<ResumeController, ResumeView>() {
    override fun getControllerClass(): Class<ResumeController> = ResumeController::class.java
    override fun createView(): ResumeView = ResumeView()

    @Test
    fun `when the game is over, and the user wants to start again, the view should return true`() {
        `when`(console.askBoolean(anyString())).thenReturn(true)

        assertTrue(view.resume(controller, console))

        verify(console, times(1)).askBoolean(anyString())
        verify(controller, times(1)).reset()
    }

    @Test
    fun `when the game is over, and the user doesn't want to go on, the view should return false`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)

        assertFalse(view.resume(controller, console))

        verify(console, times(1)).askBoolean(anyString())
        verify(console, times(1)).writeLn(Messages.GOOD_BYE)
        verify(controller, times(1)).nextState()
    }
}