package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertTrue
import org.junit.Test

class EncoderFactoryTest {

    @Test
    fun getEncoder() {
        val factory = EncoderFactory()
        val s1 = factory.getEncoder(1)
        assertTrue(s1 is EncoderStateLevel1)
        val s2 = factory.getEncoder(2)
        assertTrue(s2 is EncoderStateLevel2)
        val s3 = factory.getEncoder(3)
        assertTrue(s3 is EncoderStateLevel3)
        val s4 = factory.getEncoder(4)
        assertTrue(s4 is EncoderStateLevel4)
        val s5 = factory.getEncoder(5)
        assertTrue(s5 is EncoderStateLevel5)
        val s6 = factory.getEncoder(6)
        assertTrue(s6 is EncoderStateLevel6)
        val s7 = factory.getEncoder(7)
        assertTrue(s7 is EncoderStateLevel7)
        val s8 = factory.getEncoder(8)
        assertTrue(s8 is EncoderStateLevel8)
    }
}