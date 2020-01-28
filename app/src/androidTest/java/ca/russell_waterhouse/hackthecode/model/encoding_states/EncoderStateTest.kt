package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import ca.russell_waterhouse.hackthecode.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EncoderStateTest {

    private lateinit var context: Context

    @Before
    fun setup(){
        context= InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun testString() {
        var encoder: EncoderState = EncoderStateLevel1()
//        test it works as expected standard
        var expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[0]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        var correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[0]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel2()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[1]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[1]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel3()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[2]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[2]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel4()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[3]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[3]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel5()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[4]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[4]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel6()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[5]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[5]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel7()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[6]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[6]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))

        encoder = EncoderStateLevel8()
//        test it works as expected standard
        expectedCorrectInput = context.resources.getStringArray(R.array.decoded_level_words)[7]
        assertTrue(encoder.testString(context, expectedCorrectInput))
        assertFalse(encoder.testString(context, "Incorrect String"))
//        test it works with surrounding whitespace
        correctExpressionWithWhitespace = context.resources.getStringArray(R.array.decoded_level_words)[7]
        correctExpressionWithWhitespace = " $correctExpressionWithWhitespace "
        assertTrue(encoder.testString(context, correctExpressionWithWhitespace))
    }

    @Test
    fun getHint() {
        var encoder: EncoderState = EncoderStateLevel1()
        var expectedHint = context.resources.getStringArray(R.array.hint_array)[0]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel2()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[1]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel3()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[2]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel4()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[3]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel5()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[4]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel6()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[5]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel7()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[6]
        assertEquals(expectedHint, encoder.getHint(context))

        encoder = EncoderStateLevel8()
        expectedHint = context.resources.getStringArray(R.array.hint_array)[7]
        assertEquals(expectedHint, encoder.getHint(context))
    }

    @Test
    fun getLevelWord() {
        var encoder: EncoderState = EncoderStateLevel1()
        var expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[0]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel2()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[1]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel3()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[2]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel4()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[3]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel5()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[4]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel6()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[5]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel7()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[6]
        assertEquals(expectedWord, encoder.getLevelWord(context))

        encoder= EncoderStateLevel8()
        expectedWord = context.resources.getStringArray(R.array.encoded_level_words)[7]
        assertEquals(expectedWord, encoder.getLevelWord(context))
    }
}