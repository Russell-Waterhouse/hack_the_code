package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import ca.russell_waterhouse.hackthecode.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EncoderStateLevel1Test {

    private lateinit var context: Context

    @Before
    fun setup(){
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getLevel() {
        val encoder = EncoderStateLevel1()
        assertEquals(1, encoder.getLevel())
    }

    @Test
    fun encode() {
        val encoder = EncoderStateLevel1()

//        test it works as expected for regular input
        assertEquals("Thos os rigaler onpat thet wi cen Ixpict", encoder.encode("This is regular input that we can Expect"))
//        test it works as expected for input with numbers
        assertEquals("nambirs1204879473207", encoder.encode("numbers1204879473207"))
//        test it works as expected for input with capital letters
        assertEquals("THOS OS ELL CEPS", encoder.encode("THIS IS ALL CAPS"))
//        test it works as expected with non-alpha characters
        assertEquals("!@#$%^&*()_+-=;'/", encoder.encode("!@#$%^&*()_+-=;'/"))
    }

    @Test
    fun testString() {
        val encoder = EncoderStateLevel1()
//        test it works as expected standard
        val expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[0]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        var correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[0]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))
    }

    @Test
    fun getHint() {
        val encoder = EncoderStateLevel1()
        val expectedHint = context.resources.getStringArray(R.array.hint_array)[0]
//        test it returns the correct hint
        assertEquals(expectedHint, encoder.getHint(context))
    }


    @Test
    fun getLevelWord() {
        val encoder = EncoderStateLevel1()
        val expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[0]
        assertEquals(expectedWord, encoder.getLevelWord(context))
    }
}