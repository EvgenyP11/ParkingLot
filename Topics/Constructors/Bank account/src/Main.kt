class BankAccount(var deposited: Long, var withdrawn: Long) {
    val balance  = deposited - withdrawn
}