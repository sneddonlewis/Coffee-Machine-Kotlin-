package machine.commands

import machine.CoffeeMachineStock
import machine.UserInteraction
import machine.contracts.MachineCommand
import machine.contracts.VendingMachine

class Fill(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    ): MachineCommand {
    override fun execute() {
        val water = interaction.askForInt(makeFillString("ml of water"))
        val milk = interaction.askForInt(makeFillString("ml of milk"))
        val beans = interaction.askForInt(makeFillString("grams of coffee beans"))
        val cups = interaction.askForInt(makeFillString("disposable cups"))

        this.machine.fill(CoffeeMachineStock(water, milk, beans, cups))
    }

    private fun makeFillString(fillWith: String): String =
        "Write how many $fillWith you want to add:"
}