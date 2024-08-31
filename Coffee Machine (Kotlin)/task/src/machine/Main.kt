package machine

fun main() {
    val machine = CoffeeMachineConsole(
        CoffeeMachine(400, 540, 120, 9),
        ConsoleInteraction(),
        DollarMoney(550),
        )
    machine.run()
}
