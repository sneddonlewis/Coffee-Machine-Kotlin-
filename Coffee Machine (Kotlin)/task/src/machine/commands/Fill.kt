package machine.commands

import machine.StockFillRequest
import machine.StockFillItem
import machine.UserInteraction
import machine.contracts.VendingMachine

class Fill(
    private val machine: VendingMachine,
    private val interaction: UserInteraction,
    ): MachineCommand {
    override fun execute() {
        val stockItems = machine.getStockItems()
            .map { StockFillItem(it.key, interaction.askForInt(it.prompt)) }

        this.machine.fill(StockFillRequest(stockItems))
    }

}