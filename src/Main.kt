import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    val customers = ArrayList<Customer>()

    customers.add(Customer(customers.size.toLong()+1, "Jane", 45.25))
    customers.add(Customer(customers.size.toLong()+1, "Bob", 33.14))

/*    val customerJane = Customer(1, "Jane", 45.25)
    val customerBob = Customer(2, "Bob", 33.14)*/


    val machines = ArrayList<VendingMachine>()
    machines.add(VendingMachine(machines.size.toLong()+1, "Food"))
    machines.add(VendingMachine(machines.size.toLong()+1, "Drink"))
    machines.add(VendingMachine(machines.size.toLong()+1, "Office"))

//    val vendingFood = VendingMachine(1, "Food")
//    val vendingDrink = VendingMachine(2, "Drink")
//    val vendingOffice = VendingMachine(3, "Office")

    val snacks = ArrayList<Snack>()
    snacks.add(Snack(snacks.size.toLong()+1,"Chips", 36, 1.75, 1))
    snacks.add(Snack(snacks.size.toLong()+1,"Chocolate Bar", 36, 1.00, 1))
    snacks.add(Snack(snacks.size.toLong()+1,"Pretzel", 30, 2.00, 1))
    snacks.add(Snack(snacks.size.toLong()+1,"Soda", 24, 2.50, 2))
    snacks.add(Snack(snacks.size.toLong()+1,"Water", 36, 1.75, 2))

/*    val snackChips = Snack(1, "Chips", 36, 1.75, 1)
    val snackChocolateBar = Snack(2, "Chocolate Bar", 36, 1.00, 1)
    val snackPretzel = Snack(3, "Pretzel", 30, 2.00, 1)
    val snackSoda = Snack(4, "Soda", 24, 2.50, 1)
    val snackWater = Snack(5, "Water", 20, 2.75, 1)*/

var menuSelection = 0
    while (menuSelection!=3) {
        menuSelection = menu()

        when(menuSelection) {
            1-> {
                println("Which customer are you?")
                for (customer in customers) {
                    println("${customer.id}.  ${customer.name}")
                }
                val menuSelection = Scanner(System.`in`)
                when(menuSelection.nextInt()){
                    
                }
            }


        }

    }


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

fun menu(): Int {
    var userInput = 3
    val input = Scanner(System.`in`)

    println("Are you a customer or manager?")
    println("1. Customer")
    println("2. Manager")
    println("3.Quit")
    println("Enter choice:")
    userInput = input.nextInt()

    return userInput

}