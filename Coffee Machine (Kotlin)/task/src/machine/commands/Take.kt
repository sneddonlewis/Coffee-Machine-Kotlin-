package machine.commands

import machine.CoffeeMachine
import machine.Money
import machine.UserInteraction

class Take(
    private val machine: CoffeeMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ): MachineCommand {
    override fun execute() {
        val movedAmount = this.machine.takeAllMoney(purse);
        this.interaction.write("I gave you $$movedAmount")
    }
}