package connect4.common.view

import connect4.common.controller.ResumeController
import connect4.test.View
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString

@View
class ResumeViewTest {
    @Test
    fun `when the game is over, and the user wants to start again, the view should return true`() {
        val console = Mockito.mock(Console::class.java)
        val controller = Mockito.mock(ResumeController::class.java)
        val view = ResumeView()

        `when`(console.askBoolean(anyString())).thenReturn(true)

        assertTrue(view.resume(controller, console))
    }
}