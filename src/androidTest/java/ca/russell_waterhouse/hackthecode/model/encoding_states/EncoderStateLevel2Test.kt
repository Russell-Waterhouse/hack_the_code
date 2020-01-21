package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EncoderStateLevel2Test {

    private lateinit var context: Context

    @Before
    fun setUp() {
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel2()
        assertEquals(2, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel2()
        assertEquals("!sdrawkcaB", encoderState.encode("Backwards!"))
    }
}