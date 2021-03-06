package ca.russell_waterhouse.hackthecode.model.encoding_states

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
        assertEquals("tij", encoderState.encode("the"))
        assertEquals("edt", encoderState.encode("cat"))
        assertEquals("ecg", encoderState.encode("bag"))
        assertEquals("oSud tij Fisaul", encoderState.encode("Rico the Freako"))
        assertEquals("n o  p a i r s", encoderState.encode("n o  p a i r s"))
        assertEquals("uXrolng oxth tij besin eiwry efy pusunivs pusbimm utlowng sollls", encoderState.encode("Working with the brain every day promotes problem solving skills"))
        assertEquals("aeiouAEIOU", encoderState.encode("aeiouAEIOU"))
        assertEquals("ecidofugahEjIkOlUmAn", encoderState.encode("bacedifoguhAjEkIlOmU"))
        assertEquals("eB", encoderState.encode("Za"))
        assertEquals("eb", encoderState.encode("za"))
    }
}