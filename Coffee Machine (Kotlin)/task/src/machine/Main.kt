package machine

import machine.implementations.CoffeeMachine

fun main() {
    MachineConsole(
        CoffeeMachine(400, 540, 120, 9, DollarMoney(550)),
        ConsoleInteraction(),
        DollarMoney(),
    ).run()
}
