class Snack(val id: Long, var name: String, qty: Int = 0, var cost: Double, vendingid: Long) {

    var qty: Int = qty
        private set(value) {
            field = value
        }

    fun reStock(restockQty: Int): Int {
        qty = qty.plus(restockQty)
        return qty
    }

    fun buy(buyQty: Int): Double {
        return if (qty < buyQty) {
            println("Error: $this.qty items in stock. Not enough items in stock to fill order.")
            0.0
        } else {
            qty = qty.minus(buyQty)
            buyQty.times(cost)
        }
    }

    fun getTotalCost(checkQty: Int): Double {
        return checkQty.times(cost)
    }
}


class VendingMachine(val id: Long, var name: String)

class Customer(val id: Long, var name: String, cashOnHand: Double) {

    var cashOnHand: Double = cashOnHand
        private set(value) {
            field = value
        }

    fun addCash(cashToAdd: Double): Double {
        cashOnHand = cashOnHand.plus(cashToAdd)
        return cashOnHand
    }

    fun buy(total: Double) {
        if (total > cashOnHand) {
            println("Not enough cash to complete purchase")
        } else {
            cashOnHand = cashOnHand.minus(total)
        }
    }

    fun isBroke(): Boolean {
        return cashOnHand <= 0
    }
}