package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel8Test {

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel8()
        assertEquals(8, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel8()
        assertEquals("_e", encoderState.encode("a"))
        assertEquals("c_e", encoderState.encode("ba"))
        assertEquals("iu vpu s mwmiu tuvmvspD_uheaeop!Ns iiteitu udn!", encoderState.encode("Congratulations! More levels are soon to come!"))
    }
}