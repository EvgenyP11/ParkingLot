fun main() {
    val numbers = MutableList(100){ 0 }
    for (index in numbers.indices) {
        when(index){
            0 -> numbers[index] += index + 1
            9 -> numbers[index] += index + 1
            99 -> numbers[index] += index + 1
        }
    }
    println(numbers.joinToString())
}