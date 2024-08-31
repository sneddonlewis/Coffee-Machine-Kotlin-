package machine.commands

import machine.UserInteraction

class Invalid(private val interaction: UserInteraction): MachineCommand {
    override fun execute() {
        this.interaction.write("bork")
    }
}