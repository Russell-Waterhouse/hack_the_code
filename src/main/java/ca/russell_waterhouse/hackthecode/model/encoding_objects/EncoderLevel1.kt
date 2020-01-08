package ca.russell_waterhouse.hackthecode.model.encoding_objects

import android.content.Context

class EncoderLevel1: Encoder {

    override fun getLevel(): Int {
        return 1
    }

    override fun encode(word: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun testString(word: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHint(context: Context): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}