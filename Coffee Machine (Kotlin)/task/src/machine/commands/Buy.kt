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
        val choice = interaction.askForString("What do you want to buy: $optionsStr, back - to main menu:")
        if (choice == "back") {
            return
        }
        try {
            val selection = choice.toInt()
            // todo - if choice is <=0 or > items length then you're borking
            val coffeeResult = this.machine.buy(itemsOnSale[selection - 1], purse)
            interaction.write(coffeeResult.message)
        }
        catch (_: NumberFormatException) {
            return
        }
    }
}