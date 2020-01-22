package ca.russell_waterhouse.hackthecode.model.encoding_states

class EncoderStateLevel5: EncoderState() {
    override fun getLevel(): Int {
        return 5
    }

    override fun encode(word: String): String {
        TODO("finish by moving word ahead more than 1 spot")
        val builder = StringBuilder()
        for (char: Char in word){
            if (char.isLetter()) {
                val newChar = if (char.equals('z', ignoreCase = true)){
                    char.toInt() - 25
                } else{
                    char.toInt() +  1
                }
                builder.append(newChar.toChar())
            }
            else{
                builder.append(char)
            }
        }
        return builder.toString()
    }
}