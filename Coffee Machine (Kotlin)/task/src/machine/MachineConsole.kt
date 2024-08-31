package machine

import machine.commands.*
import machine.contracts.VendingMachine

class MachineConsole(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ) {

    fun run(): Unit {
        displayMachineContents()

        when(interaction.askForString("Write action (buy, fill, take):")) {
            "buy" -> Buy(machine, interaction, purse)
            "fill" -> Fill(machine, interaction)
            "take" -> Take(machine, interaction, purse)
            else -> Invalid(interaction)
        }.execute()

        displayMachineContents()
    }

    private fun displayMachineContents(): Unit = this.interaction.write(this.machine)
}