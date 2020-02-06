package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel6Test {

    @Test
    fun getLevel() {
        val encoderState = EncoderStateLevel6()
        assertEquals(6,encoderState.getLevel())
    }

    @Test
    fun encode() {
        val encoderState = EncoderStateLevel6()
        assertEquals("na_na",encoderState.encode("anna"))
        assertEquals("ypitri rigt ilm_e lko nyts enr M",encoderState.encode("My printer is trying to kill me"))
    }
}