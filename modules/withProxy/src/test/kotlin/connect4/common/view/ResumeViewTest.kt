package connect4.common.view

import connect4.common.controller.ResumeController
import connect4.test.MockInitializer
import connect4.test.View
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*

@View
class ResumeViewTest: MockInitializer() {
    @Mock
    lateinit var console: Console

    @Mock
    lateinit var controller: ResumeController

    @InjectMocks
    lateinit var view: ResumeView

    @Test
    fun `when the game is over, and the user wants to start again, the view should return true`() {
        `when`(console.askBoolean(anyString())).thenReturn(true)
        assertTrue(view.resume(controller, console))

        with(inOrder(console, controller)) {
            verify(console, times(1)).askBoolean(anyString())
            verify(controller, times(1)).reset()
        }
    }

    @Test
    fun `when the game is over, and the user doesn't want to repeat, the view should return false`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)
        assertFalse(view.resume(controller, console))

        with(inOrder(console, controller)) {
            verify(console, times(1)).askBoolean(anyString())
            verify(console, times(1)).writeLn(Messages.GOOD_BYE)
            verify(controller, times(1)).nextState()
        }
    }
}