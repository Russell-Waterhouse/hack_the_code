package ca.russell_waterhouse.hackthecode.model.encoding_objects

import android.content.Context

interface Encoder {
    fun getLevel(): Int
    fun encode(word: String): String
    fun testString(word: String): Boolean
    fun getHint(context: Context): String
}