open class Tea(val cost: Int, val volume: Int) {
    override fun toString(): String {
        return "cost=$cost, volume=$volume"
    }
}

class BlackTea(cost: Int, volume: Int): Tea(cost, volume) {
    var val_cost = cost
    var val_volume = volume
    override fun toString(): String {
        return "BlackTea{cost=$val_cost, volume=$val_volume}"
    }
}