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
        TODO("algorithm not yet defined and thus cannot yet be tested")
    }
}