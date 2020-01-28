package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel2Test {

    @Test
    fun getLevel() {
        val encoderState =
            EncoderStateLevel2()
        assertEquals(2, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel2()
        assertEquals("!sdrawkcaB", encoderState.encode("Backwards!"))
        assertEquals("!tarb taf gib a si tac yM", encoderState.encode("My cat is a big fat brat!"))
    }
}