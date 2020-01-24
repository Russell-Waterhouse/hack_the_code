package ca.russell_waterhouse.hackthecode.model.encoding_states

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
        while (i < numbers.size - 1){
            newNumbers[i] = numbers[i] - numbers[i-1]
            i++
        }
        newNumbers = newNumbers.reversedArray()
        i = 1
        numbers[0] = newNumbers[0]
        while (i < numbers.size){
            numbers[i] = newNumbers[i] + newNumbers[i-1]
            i++
        }
        return intArrayToString(numbers)
    }

    private fun numberFromLetter(letter: Char): Int{
        return (letter.toInt() - 'A'.toInt() + 1)
    }

    private fun intArrayToString(array: IntArray): String{
        val builder = StringBuilder()
        for (i in array){
            builder.append(i)
            builder.append(",")
        }
        return builder.toString()
    }
}