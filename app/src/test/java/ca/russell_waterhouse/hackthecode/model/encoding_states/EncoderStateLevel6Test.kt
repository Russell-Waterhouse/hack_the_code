package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel6Test {

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel6()
        assertEquals(6, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel6()
        assertEquals("1,", encoderState.encode("A"))
        assertEquals("33,", encoderState.encode("a"))
        assertEquals("20,8,9,19, 9,19, 1, 19,5,14,20,5,14,3,5,", encoderState.encode("THIS IS A SENTENCE"))
        assertEquals("52,40,41,51, 41,51, 33, 51,37,46,52,37,46,35,37,", encoderState.encode("this is a sentence"))
        assertEquals("<1><2><3><4><5><6>", encoderState.encode("123456"))
        assertEquals("<>?!@#$%^&*()_+-=", encoderState.encode("<>?!@#$%^&*()_+-="))
        assertEquals("13,57, 48,50,41,46,52,37,50, 41,51, 52,50,57,41,46,39, 52,47, 43,41,44,44, 45,37,",
            encoderState.encode("My printer is trying to kill me"))
    }
}