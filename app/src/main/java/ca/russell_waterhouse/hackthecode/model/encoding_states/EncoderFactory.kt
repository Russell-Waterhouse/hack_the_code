package ca.russell_waterhouse.hackthecode.model.encoding_states

import java.security.InvalidParameterException

class EncoderFactory {

    fun getEncoder(level: Int): EncoderState{
        return when (level) {
            1 -> EncoderStateLevel1()
            2 -> EncoderStateLevel2()
            3 -> EncoderStateLevel3()
            4 -> EncoderStateLevel4()
            5 -> EncoderStateLevel5()
            6 -> EncoderStateLevel6()
            7 -> EncoderStateLevel7()
            8 -> EncoderStateLevel8()
            else -> throw InvalidParameterException("An invalid level number "+ level +"was passed as a parameter")
        }
    }
}