

class CustomerInfo(
    /** Unique user id */
    val uid: String,
    /** Operation system: Windows, Linux, macOS, iOS */
    val operationSystem: String,
    /** In GB */
    val ram: Int,
    /** In GHz */
    val coreSpeed: Double,
    val timeStamp: Long
) {
    override fun toString(): String {
        return "CustomerInfo val_uid $uid, " +
                "val_operationSystem $operationSystem " +
                "val_ram $ram " +
                "val_coreSpeed $coreSpeed " +
                "val_timeStamp $timeStamp"
    }
}

fun sendCustomerInfoToServer(customer: CustomerInfo) {
    Server.send(customer.toString())
}