package ca.russell_waterhouse.hackthecode.model.encoding_states

import org.junit.Assert.assertEquals
import org.junit.Test

class EncoderStateLevel1Test {

    @Test
    fun getLevel() {
        val encoder =
            EncoderStateLevel1()
        assertEquals(1, encoder.getLevel())
    }

    @Test
    fun encode() {
        val encoder =
            EncoderStateLevel1()

//        test it works as expected for regular input
        assertEquals("Thos os rigaler onpat thet wi cen Ixpict", encoder.encode("This is regular input that we can Expect"))
//        test it works as expected for input with numbers
        assertEquals("nambirs1204879473207", encoder.encode("numbers1204879473207"))
//        test it works as expected for input with capital letters
        assertEquals("THOS OS ELL CEPS", encoder.encode("THIS IS ALL CAPS"))
//        test it works as expected with non-alpha characters
        assertEquals("!@#$%^&*()_+-=;'/", encoder.encode("!@#$%^&*()_+-=;'/"))
        assertEquals("aeiouAEIOU", encoder.encode("uaeioUAEIO"))
    }
}