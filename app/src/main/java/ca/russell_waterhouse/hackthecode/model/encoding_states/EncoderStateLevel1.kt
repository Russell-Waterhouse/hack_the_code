package ca.russell_waterhouse.hackthecode.model.encoding_states

open class EncoderStateLevel1: EncoderState() {

    override fun getLevel(): Int {
        return 1
    }

    override fun encode(word: String): String {
        val encodedWord = StringBuilder()
        for (letter in word){
            when(letter){
                'a' -> encodedWord.append('e')
                'e' -> encodedWord.append('i')
                'i' -> encodedWord.append('o')
                'o' -> encodedWord.append('u')
                'u' -> encodedWord.append('a')
                'A' -> encodedWord.append('E')
                'E' -> encodedWord.append('I')
                'I' -> encodedWord.append('O')
                'O' -> encodedWord.append('U')
                'U' -> encodedWord.append('A')
                else -> encodedWord.append(letter)
            }
        }
        return encodedWord.toString()
    }
}