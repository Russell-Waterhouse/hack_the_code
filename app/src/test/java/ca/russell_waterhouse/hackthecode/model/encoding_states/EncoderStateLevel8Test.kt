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
        assertEquals("1,", encoderState.encode("A"))
        assertEquals("19,49,33, ,19,2,31,50,", encoderState.encode("Brat Cat"))
        assertEquals("-68,-76,-10,10,47, ,-5,47, ,-1, ,-4,47, ,-13,4,50, ,-13,-10,37,47, " +
                ",-69,-62,14,-10, ,42,37, ,-9,38, ,15,1,37, ,1,2,10,12,41, ,-3,-15,40, ,-7,-2,-6,4,8,-11,-1,1,10,47, " +
                ",-1,46, ,5,4,5,-5,8,8,-20,-8,20,2,-6,4,-8,43,47,",
            encoderState.encode("Congratulations on completing the first set of Levels. More are soon to come!"))
        assertEquals("-68,-76,-10,10,47, ,-5,47, ,-1, ,-4,47, ,-13,4,50, ,7,14,-10, ,10,37, ,-13,-10,37,47, ,-82,-77,4,5,-5,8,8,-20,-8,20,2,-6,4,-8,43,47,", encoderState.encode("Congratulations! More levels are soon to come!"))
        assertEquals("-1,-68,-48,49,33, ,19,2,31,50,", encoderState.encode("Brat Cat10"))
        assertEquals("1,2,2,2,2,2,2,2,2,-15,", encoderState.encode("0123456789"))
    }
}