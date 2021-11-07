package connect4.common.view

import org.mockito.Mockito.*
import org.junit.jupiter.api.BeforeEach

abstract class ViewTest<C, V>(private val controllerClass: Class<C>, private val viewProvider: () -> V) {
    protected lateinit var console: Console
    protected var view: V = viewProvider.invoke()
    protected var controller: C = mock(controllerClass)

    @BeforeEach
    fun init() {
        this.view = this.viewProvider.invoke()
        this.controller = mock(controllerClass)
        this.console = mock(Console::class.java)
    }
}