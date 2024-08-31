package machine.commands

import machine.*
import machine.contracts.MachineCommand
import machine.contracts.VendingMachine

class Buy(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ): MachineCommand {
    override fun execute() {
        when (interaction.askForInt("What do you want to buy: 1 - espresso, 2 - latte, 3 - cappuccino:")) {
            1 -> this.machine.buy(Coffee.ESPRESSO, purse)
            2 -> this.machine.buy(Coffee.LATTE, purse)
            3 -> this.machine.buy(Coffee.CAPPUCCINO, purse)
        }
    }
}