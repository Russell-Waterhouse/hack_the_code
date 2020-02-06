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
    }
}