/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package connect4.common.model

import connect4.common.test.Fast
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

@Fast
internal class StateTest {
    @Test
    fun `given a new state, when no calls done, expect value to be START`() {
        val state = State()
        assertEquals(StateValue.START, state.value)
    }

    @Test
    fun `given a new state, when next() called, expect value to be PLAY`() {
        val state = State()
        state.next()
        assertEquals(StateValue.PLAY, state.value)
    }

    @Test
    fun `given a PLAY state, when next() called, expect value to be RESUME`() {
        val state = State()
        state.next()
        state.next()
        assertEquals(StateValue.RESUME, state.value)
    }

    @Test
    fun `given a RESUME state, when next() called, expect to fail`() {
        val state = State()
        state.next()
        state.next()
        assertThrows(ArrayIndexOutOfBoundsException::class.java) { state.next() }
    }

    @Test
    fun `given a RESUME state, when reset() called, expect value to be START`() {
        val state = State()
        state.next()
        state.next()
        state.reset()
        assertEquals(StateValue.START, state.value)
    }
}
