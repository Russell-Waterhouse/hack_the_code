package ca.russell_waterhouse.hackthecode.model.encoding_objects

import android.content.Context
import ca.russell_waterhouse.hackthecode.R
import java.lang.StringBuilder

class EncoderLevel1: Encoder {

    override fun getLevel(): Int {
        return 1
    }

    override fun encode(word: String): String {
        val encodedWord = StringBuilder()
        for (letter in word){
            when(letter){
                'a' -> encodedWord.append('e')
                'e' -> encodedWord.append('i')
                'i' -> encodedWord.append('o')
                'o' -> encodedWord.append('u')
                'u' -> encodedWord.append('a')
                'A' -> encodedWord.append('E')
                'E' -> encodedWord.append('I')
                'I' -> encodedWord.append('O')
                'O' -> encodedWord.append('U')
                'U' -> encodedWord.append('A')
                else -> encodedWord.append(letter)
            }
        }
        return encodedWord.toString()
    }

    override fun testString(context: Context, word: String): Boolean {
        return word.trim() == context.getString(R.string.level_1_decoded)
    }

    override fun getHint(context: Context): String {
        return context.getString(R.string.level_1_hint)
    }

    override fun getLevelWord(context: Context): String {
        return context.getString(R.string.level_1_encoded)
    }
}