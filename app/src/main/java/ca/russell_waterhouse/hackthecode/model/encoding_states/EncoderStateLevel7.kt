package ca.russell_waterhouse.hackthecode.model.encoding_states

import kotlin.math.ceil

class EncoderStateLevel7: EncoderState() {
    override fun getLevel(): Int {
        return 7
    }

    override fun encode(word: String): String {
        val builder = StringBuilder()
        val vowels = ArrayList<PositionChar>()
        val otherChars = ArrayList<PositionChar>()
        val spaces = ArrayList<PositionChar>()
        val wordLength = word.length
        var i = 0
        while (i < wordLength){
            val currChar = word[i]
            when {
                isVowel(currChar) -> {
                    vowels.add(PositionChar(currChar, i))
                }
                currChar.isWhitespace() ->
                    spaces.add(PositionChar(currChar, i))
                else -> {
                    otherChars.add(PositionChar(currChar, i))
                }
            }
            i++
        }

        i = 0
        val vowelSize: Double = vowels.size - 1.0
        while (i < ceil((vowelSize/2))){
            val backIndex = vowelSize.toInt() - i
            val tempPosition = vowels[i].position
            vowels[i].position = vowels[backIndex].position
            vowels[backIndex].position = tempPosition
            i++
        }

        vowels.sortBy { it.position }
        spaces.sortBy { it.position }
        otherChars.sortBy { it.position }
        otherChars.reverse()
        i = 0
        while (i < wordLength){
            val firstVowel = if(vowels.isEmpty()){
                PositionChar('0', -1)
            }
            else{
                vowels.first()
            }
            val firstSpace = if(spaces.isEmpty()){
                PositionChar('0', -1)
            }
            else{
                spaces.first()
            }
            val firstOther = if (otherChars.isEmpty()) {
                PositionChar('0', -1)
            }
            else {
                otherChars.first()
            }
            when {
                firstSpace.position == i ->{
                    builder.append(firstSpace.char)
                    spaces.remove(firstSpace)
                }
                firstVowel.position == i -> {
                    builder.append(firstVowel.char)
                    vowels.remove(firstVowel)
                }
                else -> {
                    builder.append(firstOther.char)
                    otherChars.remove(firstOther)
                }
            }
            i++
        }
        return builder.toString()
    }

    private data class PositionChar(val char: Char, var position: Int)
}