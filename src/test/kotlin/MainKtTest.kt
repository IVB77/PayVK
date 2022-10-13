import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionAmountVkPay() {
        val amnt = 10000
        val amntMnth = 10000
        val card = "VK Pay"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(0, result)
    }

    @Test
    fun commissionAmountVisa() {
        val amnt = 10000
        val amntMnth = 10000
        val card = "Visa"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(75, result)
    }

    @Test
    fun commissionAmountVisaMin35() {
        val amnt = 1000
        val amntMnth = 1000
        val card = "Visa"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(35, result)
    }

    @Test
    fun commissionAmountMasterCardTill75000() {
        val amnt = 10000
        val amntMnth = 10000
        val card = "MasterCard"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(0, result)
    }

    @Test
    fun commissionAmountMasterCardIn75000() {
        val amnt = 20000
        val amntMnth = 60000
        val card = "MasterCard"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(50, result)
    }

    @Test
    fun commissionAmountMasterCardFrom75000() {
        val amnt = 25000
        val amntMnth = 80000
        val card = "MasterCard"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(170, result)
    }

    @Test
    fun commissionAmountWrongCard() {
        val amnt = 25000
        val amntMnth = 80000
        val card = "Master"
        val result = commissionAmount(amnt, amntMnth, card)
        assertEquals(-1, result)
    }

    @Test
    fun commissionAmountDefault() {
        val amnt = 25000
        val result = commissionAmount(amnt)
        assertEquals(0, result)
    }

    @Test
    fun checkAmountDefaultFromLimit() {
        val amnt = 25000
        val result = checkAmount(amnt)
        assertEquals(false, result)
    }

    @Test
    fun checkAmountDefaultInLimit() {
        val amnt = 10000
        val result = checkAmount(amnt)
        assertEquals(true, result)
    }

    @Test
    fun checkAmountOtherCardInLimit() {
        val amnt = 10000
        val amntMnth = 10000
        val card = "Visa"
        val result = checkAmount(amnt, amntMnth, card)
        assertEquals(true, result)
    }

    @Test
    fun checkAmountOtherCardFromLimitMonth() {
        val amnt = 10000
        val amntMnth = 650000
        val card = "Visa"
        val result = checkAmount(amnt, amntMnth, card)
        assertEquals(false, result)
    }

    @Test
    fun checkAmountOtherCardFromLimitAmount() {
        val amnt = 180000
        val amntMnth = 60000
        val card = "Visa"
        val result = checkAmount(amnt, amntMnth, card)
        assertEquals(false, result)
    }

    @Test
    fun checkAmountVkPayFromLimitMonth() {
        val amnt = 1000
        val amntMnth = 100000
        val card = "VK Pay"
        val result = checkAmount(amnt, amntMnth, card)
        assertEquals(false, result)
    }

   /* @Test
    fun mainDefault(){
        val result = main()
        assertEquals("Сумма комиссии с Вашего перевода составит 620 руб.",result)
    }*/
}
