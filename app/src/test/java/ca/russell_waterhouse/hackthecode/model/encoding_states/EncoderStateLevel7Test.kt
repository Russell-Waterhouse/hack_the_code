package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel7Test {

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel7()
        assertEquals(7, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel7()
        assertEquals("a", encoderState.encode("a"))
        assertEquals("ea", encoderState.encode("ae"))
        assertEquals("lelsusR", encoderState.encode("Russell"))
        assertEquals("me lborpoN", encoderState.encode("No problem"))
    }
}