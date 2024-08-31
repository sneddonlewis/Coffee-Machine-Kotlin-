package machine.commands

import machine.Money
import machine.UserInteraction
import machine.contracts.VendingMachine

class Buy(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ): MachineCommand {
    override fun execute() {
        val itemsOnSale = machine.getItemsForSale()
        val optionsStr = itemsOnSale.mapIndexed { i, s -> "${i+1} - $s" }.joinToString(", ")
        val choice = interaction.askForInt("What do you want to buy: $optionsStr")
        // todo - if choice is <=0 or > items length then you're borking
        this.machine.buy(itemsOnSale[choice - 1], purse)
    }
}