package parking

data class Size (val _spots: Int) {
    var spots: Int = 0
    init {
        spots = if (_spots > 0) _spots else {
            println("Sorry, a parking lot has not been created.")
            0
        }
    }
}

fun getCar(spotNumber: String, parking: MutableList<String>) {//функция принемает номер парковочного места, список перковочных мест
    val index = spotNumber.split(" ").map { it.toInt() }// в переменную записывается список из одного значения преобразованного из строки в число
    if (parking[index.first() - 1] == "Spot is free.") println("There is no car in spot $spotNumber")// проверка условия пусто ли паркоместо если пусто печать сообщения
    else {//иначе возврат авто и перезапись ячейки
        parking[index.first() - 1] = "Spot is free."
        println("Spot $spotNumber is free.")
    }
}
fun takeTheCar(numberCar: String, color: String, parking: MutableList<String>) {//функция принемает номер авто строкой, цвет авто строкой, список парковочных мест
    val i = parking.indexOf("Spot is free.")// переменная возвращает идекс свободного парковочного места
    if (parking[i] == "Spot is free.") {// повторная проверка на наличие свободного места
        parking[i] = "$numberCar $color"// в ячейку записывается авто его номер и цвет
        println("$color car parked in spot ${i + 1}.")
    }

}
fun createParking(command: String, value: String): MutableList<String> {
    val parking = if (command == "create") {
        val size = Size(value.toInt())
        MutableList(size.spots) {"Spot is free."}
    } else {
        MutableList(0) {"Spot is free."}
    }
    return parking
}
fun workParking(commandAndParameterCar: List<String>, parking: MutableList<String>) {
    when(commandAndParameterCar[0]) {
        "park" -> {
            try {
                takeTheCar(commandAndParameterCar[1],commandAndParameterCar[2], parking)
            } catch (e: Exception) {
                println("Sorry, the parking lot is full.")
            }
        }
        "leave" -> getCar(commandAndParameterCar[1], parking)
    }
}
fun status(parking: MutableList<String>){
    var count = 0
    for (index in parking.indices){
        if(parking[index] != "Spot is free.") {
            println("${index + 1} ${parking[index]}")
            count += 1
        }
    }
    if (count == 0) println("Parking lot is empty.")
}
fun regByColor(parking: MutableList<String>, color: String){
    var tempListNumber: MutableList<String> = MutableList(0){""}
    for (index in parking.indices) {
        val (carNumber, carColor) = parking[index].split(" ")
        if (carColor.lowercase() == color.lowercase()) tempListNumber.add(carNumber)
    }
    if (tempListNumber.size == 0) println("No cars with color ${color.uppercase()} were found.")
    else println(tempListNumber.joinToString())
}
fun spotByColor (parking: MutableList<String>, color: String) {
    var tempSpotNumber: MutableList<Int> = MutableList(0){0}
    for (index in parking.indices) {
        val (carNumber, carColor) = parking[index].split(" ")
        if (carColor.lowercase() == color.lowercase()) tempSpotNumber.add(index + 1)
    }
    if (tempSpotNumber.size == 0) println("No cars with color ${color.uppercase()} were found.")
    else println(tempSpotNumber.joinToString())
}
fun spotByReg (parking: MutableList<String>, regNumber: String) {
    var tempSpotNumber: MutableList<Int> = MutableList(0){0}
    for (index in parking.indices) {
        val (carNumber, carColor) = parking[index].split(" ")
        if (carNumber == regNumber) tempSpotNumber.add(index + 1)
    }
    if (tempSpotNumber.size == 0) println("No cars with registration number $regNumber were found.")
    else println(tempSpotNumber.joinToString())
}

lateinit var parking: MutableList<String>
fun main() {
    while (true){
        val commandAndValue = readLine()!!.split(" ")
        val command = commandAndValue[0]
        if (command == "exit") break

        parking = if (command == "create") createParking(command, commandAndValue[1])
        else {
            createParking(command, "0")
        }
        if(parking.size != 0){
            println("Created a parking lot with ${parking.size} spots.")
            while (true) {
                val readCommandAndParameterCar = readLine()!!.split(" ").map { it }
                workParking(readCommandAndParameterCar, parking)
                if (readCommandAndParameterCar[0] == "status") status(parking)
                if (readCommandAndParameterCar[0] == "exit") return
                if (readCommandAndParameterCar[0] == "create") {
                    parking = createParking(readCommandAndParameterCar[0], readCommandAndParameterCar[1])
                }
                if (readCommandAndParameterCar[0] == "reg_by_color") regByColor(parking, readCommandAndParameterCar[1])
                if (readCommandAndParameterCar[0] == "spot_by_color") spotByColor(parking, readCommandAndParameterCar[1])
                if (readCommandAndParameterCar[0] == "spot_by_reg") spotByReg(parking, readCommandAndParameterCar[1])
            }
        } else {
            println("Sorry, a parking lot has not been created.")
        }
    }
}

