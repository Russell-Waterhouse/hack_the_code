package ca.russell_waterhouse.hackthecode.model.encoding_objects

import java.security.InvalidParameterException

class EncoderFactory {

    fun getEncoder(level: Int): Encoder{
        return when (level) {
            1 -> EncoderLevel1()
            2 -> EncoderLevel1()
            3 -> EncoderLevel1()
            4 -> EncoderLevel1()
            5 -> EncoderLevel1()
            6 -> EncoderLevel1()
            7 -> EncoderLevel1()
            8 -> EncoderLevel1()
            else -> throw InvalidParameterException("An invalid level number "+ level +"was passed as a parameter")
        }
    }
}