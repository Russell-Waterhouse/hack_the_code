package ca.russell_waterhouse.hackthecode.model.encoding_states

import java.security.InvalidParameterException

class EncoderStateLevel4: EncoderState() {
    override fun getLevel(): Int {
        return 4
    }

    override fun encode(word: String): String {
        var prevChar: Char = word[0]
        var currentChar: Char
        val wordLength = word.length
        val stringBuilder = StringBuilder()
        var needToAddLastLetter = true
        var i = 1
        while(i < wordLength){
            currentChar = word[i]
            if (isVowel(currentChar) && isConsonant(prevChar)) {
                stringBuilder.append(aheadOneVowel(currentChar))
                stringBuilder.append(aheadOneConsonant(prevChar))
                i+=2
                needToAddLastLetter = false
                if (i <= wordLength) {
                    prevChar = word[i - 1]
                    needToAddLastLetter = true
                }
            }
            else{
                stringBuilder.append(prevChar)
                prevChar = currentChar
                needToAddLastLetter = true
                i++
            }
        }
        if (needToAddLastLetter){
            stringBuilder.append(word[i-1])
        }
        return stringBuilder.toString()
    }


    
    private fun aheadOneVowel(letter: Char): Char{
        if (! isVowel(letter)){
            throw InvalidParameterException("Parameter must be a vowel but was not")
        }
        return when(letter) {
            'a' -> 'e'
            'e' -> 'i'
            'i' -> 'o'
            'o' -> 'u'
            'u' -> 'a'
            'A' -> 'E'
            'E' -> 'I'
            'I' -> 'O'
            'O' -> 'U'
            'U' -> 'A'
            else -> throw InvalidParameterException("Parameter must be a vowel but was not")
        }
    }

    private fun aheadOneConsonant(letter: Char): Char{
        if (! isConsonant(letter)){
            throw InvalidParameterException("Parameter must be a consonant but was not")
        }
        val consonantsCapital: CharArray = charArrayOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z')
        var positionInConsonants = consonantsCapital.indexOf(letter)
        if (positionInConsonants == -1){
            val consonantsLowerCase = charArrayOf( 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z')
            positionInConsonants = consonantsLowerCase.indexOf(letter)
            if (positionInConsonants == consonantsLowerCase.lastIndex){
                return consonantsLowerCase[0]
            }
            return consonantsLowerCase[positionInConsonants + 1]
        }
        if (positionInConsonants == consonantsCapital.lastIndex){
            return consonantsCapital[0]
        }
        return consonantsCapital[positionInConsonants + 1]
    }
}
