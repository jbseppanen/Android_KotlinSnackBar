fun main(args: Array<String>) {

    val customerJane = Customer(1, "Jane", 45.25)
    val customerBob = Customer(2, "Bob", 33.14)

    val vendingFood = VendingMachine(1, "Food")
    val vendingDrink = VendingMachine(2, "Drink")
    val vendingOffice = VendingMachine(3, "Office")

    val snackChips = Snack(1, "Chips", 36, 1.75, 1)
    val snackChocolateBar = Snack(2, "Chocolate Bar", 36, 1.00, 1)
    val snackPretzel = Snack(3, "Pretzel", 30, 2.00, 1)
    val snackSoda = Snack(4, "Soda", 24, 2.50, 2)
    val snackWater = Snack(5, "Water", 20, 2.75, 2)

    buyItem(customerJane, snackSoda, 3)
    buyItem(customerJane, snackPretzel, 1)
    buyItem(customerBob, snackSoda, 2)
    println("${customerJane.name} now has $${customerJane.addCash(10.0)} on hand.")
    buyItem(customerJane, snackChocolateBar, 1)
    println("${snackPretzel.name} now has ${snackPretzel.reStock(12)} in stock.")
    buyItem(customerBob, snackPretzel, 3)


}

fun buyItem(customer: Customer, snack: Snack, qty: Int) {

    val success:Boolean = when {
        customer.isBroke() -> false
        snack.getTotalCost(qty) > customer.cashOnHand -> false
        else -> {
            customer.buy(snack.buy(qty))
            true
        }
    }
    if (success) {
        println("${customer.name} bought $qty ${snack.name}(s) and has $${customer.cashOnHand} left. There are ${snack.qty} ${snack.name}(s) left.")
    } else {
        println("${customer.name} was not able to buy $qty ${snack.name}(s)and has $${customer.cashOnHand} left. There are ${snack.qty} ${snack.name}(s) left.")
    }
}
