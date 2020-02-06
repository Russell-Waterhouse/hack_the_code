package ca.russell_waterhouse.hackthecode.model.encoding_states

class EncoderStateLevel8: EncoderState() {
    override fun getLevel(): Int {
        return 8
    }

    override fun encode(word: String): String {
        val encoder1 = EncoderStateLevel5()
        val output1 = encoder1.encode(word)
        val encoder2 = EncoderStateLevel6()
        return encoder2.encode(output1)
    }
}