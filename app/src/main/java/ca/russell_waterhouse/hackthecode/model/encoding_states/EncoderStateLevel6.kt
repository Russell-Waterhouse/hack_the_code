package ca.russell_waterhouse.hackthecode.model.encoding_states

class EncoderStateLevel6: EncoderState() {
    override fun getLevel(): Int {
        return 6
    }

    override fun encode(word: String): String {
        val stringBuilderStart = StringBuilder()
        val stringBuilderEnd = StringBuilder()
        var i = 0
        val length = word.length
        while(i <= length-2) {
            stringBuilderEnd.append(word[i])
            i++
            stringBuilderStart.append(word[i])
            i++
        }
        if (i < length){
            stringBuilderEnd.append(word[i])
        }
        return stringBuilderStart.toString() + "_" + stringBuilderEnd.reversed().toString()
    }
}