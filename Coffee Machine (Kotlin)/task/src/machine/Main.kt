package machine

fun main() {
    CoffeeMachineConsole(
        CoffeeMachine(400, 540, 120, 9, DollarMoney(550)),
        ConsoleInteraction(),
        DollarMoney(),
    ).run()
}
