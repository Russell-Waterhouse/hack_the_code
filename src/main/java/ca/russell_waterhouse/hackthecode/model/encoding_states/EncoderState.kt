package ca.russell_waterhouse.hackthecode.model.encoding_states

import android.content.Context
import ca.russell_waterhouse.hackthecode.R

abstract class EncoderState {

    abstract fun getLevel(): Int

    abstract fun encode(word: String): String

    fun testString(context: Context, word: String): Boolean {
        val answers = context.resources.getStringArray(R.array.decoded_level_words)
        return word.trim() == answers[getLevel() - 1]
    }

    fun getHint(context: Context): String{
        val resources = context.resources
        val hints = resources.getStringArray(R.array.hint_array)
        return hints[getLevel() - 1]
    }

    fun getLevelWord(context: Context): String {
        val levelWords = context.resources.getStringArray(R.array.encoded_level_words)
        return levelWords[getLevel() - 1]
    }
}