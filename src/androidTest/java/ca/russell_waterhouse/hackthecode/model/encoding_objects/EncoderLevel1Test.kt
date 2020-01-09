package ca.russell_waterhouse.hackthecode.model.encoding_objects

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import ca.russell_waterhouse.hackthecode.R
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class EncoderLevel1Test {

    private lateinit var context: Context

    @Before
    fun initContext(){
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getLevel() {
        val encoder = EncoderLevel1()
        assertEquals(1, encoder.getLevel())
    }

    @Test
    fun encode() {
        val encoder = EncoderLevel1()

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
        val encoder = EncoderLevel1()
//        test it works as expected standard
        val expectedCorrectInput = context.getString(R.string.level_1_decoded)
        assert(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//      TODO:  test it works as expected with surrounding whitespace
    }

    @Test
    fun getHint() {
        val encoder = EncoderLevel1()
        val expectedHint = context.getString(R.string.level_1_hint)
//        test it returns the correct hint
        assertEquals(expectedHint, encoder.getHint(context))
    }


    @Test
    fun getLevelWord() {
        val encoder = EncoderLevel1()
        val expectedWord = context.getString(R.string.level_1_encoded)
        assertEquals(expectedWord, encoder.getLevelWord(context))
    }
}