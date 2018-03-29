package com.capitalone

fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(args: Array<String>) {
    val (totalNumberOfLines) = readInts()

    var problemNumber = 0;
    while (problemNumber++ != totalNumberOfLines) {
        val line = readLine()
        val input = line!!.split(" ")

        val maximumShyness = input[0]
        val audience = input[1]

        var totalInAudience = 0;
        var friendsToInvite = 0;

        for (shyness in 0 .. maximumShyness.toInt()) {
            if (totalInAudience < shyness) {
                val additionalFolks = shyness - totalInAudience
                friendsToInvite += additionalFolks;
                totalInAudience += additionalFolks + audience.getIntValue(shyness)
            } else {
                totalInAudience += audience.getIntValue(shyness)
            }
        }
        println("Case #$problemNumber: $friendsToInvite")
    }

}

/**
 * An extension on the Char class which substracts 48 from the ASCII code returned by toInt(). This will give you the
 * proper numerical value of the character.
 *
 * Source: https://stackoverflow.com/a/47713612/257457
 */
private fun String.getIntValue(shyness: Int): Int {
    if (this.get(shyness) !in '0'..'9') {
        throw NumberFormatException()
    }
    return this.get(shyness).toInt() - '0'.toInt()

}

