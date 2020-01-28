package ca.russell_waterhouse.hackthecode

import ca.russell_waterhouse.hackthecode.model.encoding_states.EncoderStateLevel5
import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel5Test {

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel5()
        assertEquals(5, encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel5()
        assertEquals("I", encoderState.encode("E"))
        assertEquals("u", encoderState.encode("o"))
        assertEquals("3", encoderState.encode("3"))
        assertEquals("d", encoderState.encode("c"))
        assertEquals("D", encoderState.encode("C"))
        assertEquals("B", encoderState.encode("Z"))
        assertEquals("b", encoderState.encode("z"))
        assertEquals("fsux", encoderState.encode("word"))
        assertEquals(" tfsux imqovman", encoderState.encode("multiple words "))
        assertEquals("metuqtof ihecseh e po lsug e vaq vup uF", encoderState.encode("Do not put a fork in a garbage disposal"))
    }
}