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
    }

    @Test
    fun `when the game is over, the user should answer true, to start again`() {
        `when`(console.askBoolean(anyString())).thenReturn(true)
        view.resume(controller, console)
        verify(console, times(1)).askBoolean(anyString())
    }

    @Test
    fun `when the game is over, and the user answers true to start again, the controller resets the game`() {
        `when`(console.askBoolean(anyString())).thenReturn(true)
        view.resume(controller, console)
        verify(controller, times(1)).reset()
    }

    @Test
    fun `when the game is over, and the user doesn't want to repeat, the view should return false`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)
        assertFalse(view.resume(controller, console))
        verify(console, times(1)).askBoolean(anyString())
    }

    @Test
    fun `when the game is over, if the user doesn't want to contnue should answer false`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)
        view.resume(controller, console)
        verify(console, times(1)).askBoolean(anyString())
    }

    @Test
    fun `when the game is over, and the user chooses not to continue, the game ends with a goodbye message`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)
        view.resume(controller, console)
        verify(console, times(1)).writeLn(Messages.GOOD_BYE)
    }

    @Test
    fun `when the game is over, and the user answers to not continue, the state changes`() {
        `when`(console.askBoolean(anyString())).thenReturn(false)
        view.resume(controller, console)
        verify(controller, times(1)).nextState()
    }
}