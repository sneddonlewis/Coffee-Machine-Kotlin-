package machine

fun main() {
    val userInterface: UserInteraction = ConsoleInteraction()
    val water = userInterface.askForInt(makeFillString("ml of water"))
    val milk = userInterface.askForInt(makeFillString("ml of milk"))
    val beans = userInterface.askForInt(makeFillString("grams of coffee beans"))
    val numberOfCupsRequired = userInterface.askForInt("Write how many cups of coffee you will need:")

    val numberOfCupsPossible = CoffeeMachine()
        .fillWater(water)
        .fillMilk(milk)
        .fillBeans(beans)
        .numberOfCups

    val responseString = makeResponseString(numberOfCupsRequired, numberOfCupsPossible)

    userInterface.write(responseString)
}

fun makeFillString(fillWith: String): String =
    "Write how many $fillWith the coffee machine has:"

fun makeResponseString(req: Int, poss: Int): String =
    when {
        req < poss -> "Yes, I can make that amount of coffee (and even ${poss - req} more than than)"
        req > poss -> "No, I can only make $poss cups of coffee"
        else -> "Yes, I can make that amount of coffee"
    }

