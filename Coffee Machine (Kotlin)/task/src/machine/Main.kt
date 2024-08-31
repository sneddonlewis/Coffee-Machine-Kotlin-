package machine

fun main() {
    val machine = CoffeeMachineConsole(
        CoffeeMachine(400, 540, 120, 9, DollarMoney(550)),
        ConsoleInteraction(),
        DollarMoney(),
        )
    machine.run()
}
