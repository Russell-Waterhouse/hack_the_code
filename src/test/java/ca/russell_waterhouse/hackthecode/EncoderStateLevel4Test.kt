package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderStateLevel4
import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel4Test {

    @Test
    fun getLevel() {
        val encoderState =
            EncoderStateLevel4()
        assertEquals(4, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState =
            EncoderStateLevel4()
        assertEquals("oS", encoderState.encode("Ri"))
        assertEquals("oSud tij Fisaul", encoderState.encode("Rico the Freako"))
        assertEquals("n o  p a i r s", encoderState.encode("n o  p a i r s"))
    }
}