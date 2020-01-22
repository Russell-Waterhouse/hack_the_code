package ca.russell_waterhouse.hackthecode.model.encoding_states

import java.security.InvalidParameterException

class EncoderStateLevel5: EncoderState() {
    override fun getLevel(): Int {
        return 5
    }

    override fun encode(word: String): String {
        val stringBuilder = StringBuilder()
        for (letter: Char in word){
            when {
                isConsonant(letter) -> {
                    stringBuilder.append(aheadOneConsonant(letter))
                }
                isVowel(letter) -> {
                    stringBuilder.append(aheadOneVowel(letter))
                }
                else -> {
                    stringBuilder.append(letter)
                }
            }
        }
        return stringBuilder.toString().reversed()
    }

    private fun isVowel(char: Char): Boolean {
        val vowels: CharArray = charArrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
        return char in vowels
    }

    private fun isConsonant(char: Char): Boolean {
        val consonants: CharArray = charArrayOf(
            'B',
            'C',
            'D',
            'F',
            'G',
            'H',
            'J',
            'K',
            'L',
            'M',
            'N',
            'P',
            'Q',
            'R',
            'S',
            'T',
            'V',
            'W',
            'X',
            'Y',
            'Z',
            'b',
            'c',
            'd',
            'f',
            'g',
            'h',
            'j',
            'k',
            'l',
            'm',
            'n',
            'p',
            'q',
            'r',
            's',
            't',
            'v',
            'w',
            'x',
            'y',
            'z'
        )
        return char in consonants
    }

    private fun aheadOneVowel(letter: Char): Char {
        if (!isVowel(letter)) {
            throw InvalidParameterException("Parameter must be a vowel but was not")
        }
        return when (letter) {
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

    private fun aheadOneConsonant(letter: Char): Char {
        if (!isConsonant(letter)) {
            throw InvalidParameterException("Parameter must be a consonant but was not")
        }
        val consonantsCapital: CharArray = charArrayOf(
            'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'
        )
        var positionInConsonants = consonantsCapital.indexOf(letter)
        if (positionInConsonants == -1) {
            val consonantsLowerCase = charArrayOf(
                'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
            )
            positionInConsonants = consonantsLowerCase.indexOf(letter)
            if (positionInConsonants == consonantsLowerCase.lastIndex) {
                return consonantsLowerCase[0]
            }
            return consonantsLowerCase[positionInConsonants + 1]
        }
        if (positionInConsonants == consonantsCapital.lastIndex) {
            return consonantsCapital[0]
        }
        return consonantsCapital[positionInConsonants + 1]
    }

}