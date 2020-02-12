package ca.russell_waterhouse.hackthecode.model.encoding_states


open class EncoderStateLevel2: EncoderState() {

    override fun getLevel(): Int {
        return 2
    }

    override fun encode(word: String): String {
        return word.reversed()
    }
}