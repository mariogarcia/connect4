package connect4.common.view

import org.mockito.Mockito.*
import org.junit.jupiter.api.BeforeEach

abstract class ViewTest<C, V> {
    protected lateinit var console: Console
    protected var view: V = this.createView()
    protected var controller: C = mock(this.getControllerClass())

    @BeforeEach
    fun init() {
        this.view = this.createView()
        this.controller = mock(getControllerClass())
        this.console = mock(Console::class.java)
    }

    abstract fun getControllerClass(): Class<C>
    abstract fun createView(): V
}