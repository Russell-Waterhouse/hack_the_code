package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class EncoderStateLevel4Test {

    private lateinit var context: Context

    @Before
    fun setUp() {
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel4()
        assertEquals(4, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel4()
        assertEquals("oS", encoderState.encode("Ri"))
        assertEquals("oSud tij Fisaul", encoderState.encode("Rico the Freako"))
        assertEquals("n o  p a i r s", encoderState.encode("n o  p a i r s"))
    }
}