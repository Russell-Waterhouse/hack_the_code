package ca.russell_waterhouse.hackthecode.model.encoding_states

class EncoderStateLevel6: EncoderState() {
    override fun getLevel(): Int {
        return 6
    }

    override fun encode(word: String): String {
        val stringBuilder = StringBuilder()
        for (letter: Char in word) {
            when {
                letter.isLetter() -> {
                    stringBuilder.append((letter.toInt() - 'A'.toInt() + 1).toString() + ',')
                }
                letter.isDigit() -> {
                    stringBuilder.append("<$letter>")
                }
                else -> {
                    stringBuilder.append(letter)
                }
            }
        }
        return stringBuilder.toString()
    }
}