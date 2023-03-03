fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    val num1 = numbers.first()
    val num2 = numbers.last()
    numbers[0] = num2
    numbers[numbers.size - 1] = num1
    println(numbers.joinToString(separator = " "))
}