package connect4.test

import org.junit.jupiter.api.BeforeEach
import org.mockito.MockitoAnnotations.openMocks

abstract class MockInitializer {
    @BeforeEach
    fun init() {
        openMocks(this)
    }
}