fun main() {
    val char0 = readLine()!!.encodeToByteArray()
    val char1 = readLine()!!.encodeToByteArray()
    val char2 = readLine()!!.encodeToByteArray()
    val char3 = readLine()!!.encodeToByteArray()
    var charArray = ByteArray(0)
    charArray += --char0[0]
    charArray += --char1[0]
    charArray += --char2[0]
    charArray += --char3[0]
    val char = charArray.toString(Charsets.UTF_8)
    for (i in char.indices) {
        println(char[i])
    }
}