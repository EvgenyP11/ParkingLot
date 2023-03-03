fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(var time: Int) {
    var _time: Int = time
    init {
        time = if (_time in -128 .. 127) _time
        else {
            if (_time < -128) -128 else 127
        }
    }

}