package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import ca.russell_waterhouse.hackthecode.R

abstract class EncoderState {

    abstract fun getLevel(): Int

    abstract fun encode(word: String): String

    open fun testString(context: Context, word: String): Boolean {
        val answers = context.resources.getStringArray(R.array.decoded_level_words)
        return word.trim() == answers[getLevel() - 1]
    }

    open fun getHint(context: Context): String{
        val resources = context.resources
        val hints = resources.getStringArray(R.array.hint_array)
        return hints[getLevel() - 1]
    }

    open fun getLevelWord(context: Context): String {
        val levelWords = context.resources.getStringArray(R.array.encoded_level_words)
        return levelWords[getLevel() - 1]
    }

    fun isVowel(char: Char): Boolean {
        val vowels: CharArray = charArrayOf('A', 'E', 'I', 'O', 'U','a','e','i','o','u')
        return char in vowels
    }

    fun isConsonant(char: Char): Boolean {
        val consonants: CharArray = charArrayOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
            'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z')
        return char in consonants
    }

}