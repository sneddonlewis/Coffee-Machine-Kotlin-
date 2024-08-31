package machine.commands

import machine.CoffeeMachine
import machine.CoffeeType
import machine.Money
import machine.UserInteraction

class Buy(
    private val machine: CoffeeMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ): MachineCommand {
    override fun execute() {
        when (interaction.askForInt("What do you want to buy: 1 - espresso, 2 - latte, 3 - cappuccino:")) {
            1 -> this.machine.buy(CoffeeType.ESPRESSO, purse)
            2 -> this.machine.buy(CoffeeType.LATTE, purse)
            3 -> this.machine.buy(CoffeeType.CAPPUCCINO, purse)
        }
    }
}