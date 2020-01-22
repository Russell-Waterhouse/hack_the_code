package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EncoderStateLevel3Test {

    private lateinit var context: Context

    @Before
    fun setUp() {
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel3()
        assertEquals(3, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel3()
        assertEquals("A", encoderState.encode("Z"))
        assertEquals("a", encoderState.encode("z"))
        assertEquals("BCD", encoderState.encode("ABC"))
        assertEquals("bcd", encoderState.encode("abc"))
        assertEquals("BCD EFG.?HIJ !@#$%^&*()1234567890klm", encoderState.encode("ABC DEF.?GHI !@#$%^&*()1234567890jkl"))
    }
}