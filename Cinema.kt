package cinema

const val expensivePrice = 10
const val cheapPrice = 8

fun throwPurchased (rowNumber: Int, seatNumber: Int, seatList: MutableList<MutableList<String>>) {
    if (seatList[rowNumber - 1][seatNumber - 1] == "B") {
        throw IllegalStateException("That ticket has already been purchased!")
    }
}

fun throwMaxSize (rowNumber: Int, seatNumber: Int) {
    if (rowNumber > 9 || seatNumber > 9) {
        throw IllegalArgumentException("Max number of row and seat in row is 9!")
    }
}

fun showSeats(seatNum: Int, rowNum:Int, seatList: MutableList<MutableList<String>>) {
    println()
    println("Cinema:")
    print(" ")
    for (x in 0 until seatNum) { print(" ${x + 1}") } //number of seats
    println()
    for (i in 0 until rowNum) {
        println("${i + 1} ${seatList[i].joinToString(" ")}")
    }
}

fun buyTicket(seatList: MutableList<MutableList<String>>, rowNum: Int, seatNum: Int) {
    println()
    var programRun3 = 1
    while (programRun3 == 1) {
        programRun3 = 0
        println("Enter a row number:")
        val chooseRow = readln()
        println("Enter a seat number in that row:")
        val chooseSeat = readln()
        try {
            throwPurchased(chooseRow.toInt(), chooseSeat.toInt(), seatList)
            seatList[chooseRow.toInt() - 1][chooseSeat.toInt() - 1] = "B" /* change seatList */
            print("Ticket price: ")
            if (rowNum * seatNum <= 60) {
                print("$$expensivePrice")
                println()
            } else if (rowNum % 2 == 0 && chooseRow.toInt() <= rowNum / 2) {
                print("$$expensivePrice")
                println()
            } else if (chooseRow.toInt() <= rowNum / 2) {
                print("$$expensivePrice")
                println()
            } else {
                print("$$cheapPrice")
                println()
            }
        } catch (e: IllegalStateException) {
            println()
            println("That ticket has already been purchased!")
            println()
            programRun3 = 1
        }
        catch (e: IndexOutOfBoundsException) {
            println()
            println("Wrong input!")
            programRun3 = 1
            println()
        } catch (e: Exception) {
            println()
            println("Wrong input!")
            programRun3 = 1
            println()
        }
    }
}

fun statistics(seatList: MutableList<MutableList<String>>) {
    val sizeRow = seatList.size
    val sizeSeat = seatList[0].size
    val flatList = seatList.flatten() //change 2D list to 1D
    println(flatList.size)
    val currentIncome: Int
    val totalIncome: Int
    when  {
        flatList.size > 60 -> {
            if (sizeRow % 2 == 0) {
                val subFlatList1 = flatList.subList(0, sizeRow / 2 * sizeSeat)
                val subFlatList2 = flatList.subList(sizeRow / 2 * sizeSeat, flatList.size)
                val expensiveTicket = (subFlatList1.count { it == "B" }) * expensivePrice
                val cheapTicket = (subFlatList2.count { it == "B" }) * cheapPrice
                currentIncome = expensiveTicket + cheapTicket
                totalIncome = subFlatList1.size * expensivePrice + subFlatList2.size * cheapPrice
            }
            else {
                val subFlatList1 = flatList.subList(0, sizeRow / 2 * sizeSeat)
                val subFlatList2 = flatList.subList(sizeRow / 2 * sizeSeat, flatList.size)
                val expensiveTicket = (subFlatList1.count { it == "B" }) * expensivePrice
                val cheapTicket = (subFlatList2.count { it == "B" }) * cheapPrice
                currentIncome = expensiveTicket + cheapTicket
                totalIncome = subFlatList1.size * expensivePrice + subFlatList2.size * cheapPrice
            }
        }
        else -> {
            currentIncome = (flatList.count { it == "B" }) * expensivePrice
            totalIncome = flatList.size * expensivePrice
        }
    }
    val allTicket = flatList.size
    val buyTicket = flatList.count { it == "B" }
    val percentage = buyTicket.toFloat() / allTicket.toFloat() * 100
    val percentageFormat = "%.2f".format(percentage)
    println("Number of purchased tickets: $buyTicket")
    println("Percentage: ${percentageFormat}%")
    println("Current income: $${currentIncome}")
    println("Total income: $${totalIncome}")

}

fun main() {
    var programRun1 = 1
    var programRun2 = 1
    var rowsNumber = 1
    var seatsNumber = 1

    while (programRun1 == 1) {
        programRun1 = 0
        try {
            println("Enter the number of rows:")
            rowsNumber = readln().toUInt().toInt()
            println("Enter the number of seats in each row")
            seatsNumber = readln().toUInt().toInt()
            throwMaxSize(rowsNumber, seatsNumber)
        } catch (e: NumberFormatException) {
            println()
            println("Wrong Input!")
            programRun1 = 1
            println()
        } catch (e: IllegalArgumentException) {
            println()
            println("The maximum hall size is 9 by 9!")
            programRun1 = 1
            println()
        }
    } //try check number format

    val seatList = MutableList(rowsNumber) { MutableList(seatsNumber) { "S" } } //list crate

    while (programRun2 == 1) {
        println()
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        when (readln()) {
            "1" -> { showSeats(seatsNumber, rowsNumber, seatList) }
            "2" -> { buyTicket(seatList, rowsNumber, seatsNumber) }
            "3" -> { statistics(seatList) }
            "0" -> programRun2 = 0
            else -> println("Wrong input!")
        }
    }
}
