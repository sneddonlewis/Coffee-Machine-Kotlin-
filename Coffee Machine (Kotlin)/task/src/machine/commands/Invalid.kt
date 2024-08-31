package machine.commands

import machine.UserInteraction
import machine.contracts.MachineCommand

class Invalid(private val interaction: UserInteraction): MachineCommand {
    override fun execute() {
        this.interaction.write("bork")
    }
}