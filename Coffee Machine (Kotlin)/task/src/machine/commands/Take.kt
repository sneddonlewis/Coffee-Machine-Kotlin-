package machine.commands

import machine.Money
import machine.UserInteraction
import machine.contracts.MachineCommand
import machine.contracts.VendingMachine

class Take(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ): MachineCommand {
    override fun execute() {
        val movedAmount = this.machine.takeAllMoney(purse);
        this.interaction.write("I gave you $$movedAmount")
    }
}