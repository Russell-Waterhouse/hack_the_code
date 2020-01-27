package ca.russell_waterhouse.hackthecode.model.encoding_states

import java.security.InvalidParameterException

class EncoderStateLevel8: EncoderState() {
    override fun getLevel(): Int {
        return 8
    }

    override fun encode(word: String): String {
        val numbers = IntArray(word.length)
        var i = 0
        for (letter: Char in word){
            numbers[i] = numberFromLetter(letter)
            i++
        }
        i = 1
        var newNumbers = numbers.copyOf()
        while (i < numbers.size ){
            newNumbers[i] = if (numbers[i] == 0) {
                0
            }
            else{
                numbers[i] - numbers[i-1]
            }
            i++
        }
        newNumbers = newNumbers.reversedArray()
        i = 1
        numbers[0] = newNumbers[0]
        while (i < numbers.size){
            numbers[i] =
                if (newNumbers[i] == 0) {
                    0
                } else{
                    newNumbers[i] + newNumbers[i-1]
                }
            i++
        }
        return intArrayToString(numbers)
    }

    private fun numberFromLetter(letter: Char): Int{
        return when {
            letter == ' ' -> {
                0
            }
            letter.isDigit() -> {
                throw InvalidParameterException("Letter must not be a digit")
            }
            else -> letter.toInt() - 'A'.toInt() + 1
        }
    }

    private fun intArrayToString(array: IntArray): String{
        val builder = StringBuilder()
        for (i in array){
            val appendLetter =
                if (i == 0){
                    " "
            }
            else{
                    i.toString()
                }
            builder.append(appendLetter)
            builder.append(",")
        }
        return builder.toString()
    }
}