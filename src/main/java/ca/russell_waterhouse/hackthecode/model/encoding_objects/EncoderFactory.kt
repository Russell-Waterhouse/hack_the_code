package ca.russell_waterhouse.hackthecode.model.encoding_objects

import java.security.InvalidParameterException

class EncoderFactory {

    fun getEncoder(level: Int): Encoder{
        when (level) {
            1 -> return EncoderLevel1()
            else -> throw InvalidParameterException()
        }
    }
}