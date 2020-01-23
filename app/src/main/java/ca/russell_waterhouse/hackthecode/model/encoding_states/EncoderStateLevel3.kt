package ca.russell_waterhouse.hackthecode.model.encoding_states

class EncoderStateLevel3: EncoderState() {

    override fun getLevel(): Int {
        return 3
    }

    override fun encode(word: String): String {
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