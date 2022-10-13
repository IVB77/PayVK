//package ru.netology
fun main() {
    val typePay = "MasterCard"
    val transferAmountInMonth = 500_000
    val transferAmount = 100_000
    if (!checkAmount(transferAmount, transferAmountInMonth, typePay)) {
        println("Извините, превышен лимит платежей")
        return
    }
    if (commissionAmount(transferAmount, transferAmountInMonth, typePay) < 0) {
        println("Извините Ваша карта $typePay не обслуживается")
        return
    }
    println(
        "Сумма комиссии с Вашего перевода составит ${
            commissionAmount(transferAmount, transferAmountInMonth, typePay)
        } руб."
    )
}

fun commissionAmount(transferAmount: Int, transferAmountInMonth: Int = 0, typePay: String = "VK Pay"): Int {

    return when (typePay) {
        "VK Pay" -> 0
        "Visa", "Мир" -> {
            if (transferAmount / 100 * 0.75 < 35) {
                35
            } else {
                (transferAmount / 100 * 0.75).toInt()
            }
        }
        "MasterCard", "Maestro" -> {
            if (transferAmountInMonth + transferAmount < 75_000) {
                0
            } else if (transferAmountInMonth >= 75_000) {
                (transferAmount / 100 * 0.6 + 20).toInt()
            } else {
                ((transferAmount - (75_000 - transferAmountInMonth)) / 100 * 0.6 + 20).toInt()
            }
        }
        else -> {
            -1
        }
    }

}

fun checkAmount(transferAmount: Int, transferAmountInMonth: Int = 0, typePay: String = "VK Pay"): Boolean {
    return when (typePay) {
        "VK Pay" -> !(transferAmount > 15_000 || transferAmount + transferAmountInMonth > 40_000)
        else -> !(transferAmount > 150_000 || transferAmount + transferAmountInMonth > 600_000)
    }
}