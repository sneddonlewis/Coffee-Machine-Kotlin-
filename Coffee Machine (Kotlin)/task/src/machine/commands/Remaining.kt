package machine.commands

import machine.UserInteraction
import machine.contracts.VendingMachine

class Remaining(private val machine: VendingMachine, private val interaction: UserInteraction): MachineCommand {
    override fun execute() {
        interaction.write(machine)
    }
}