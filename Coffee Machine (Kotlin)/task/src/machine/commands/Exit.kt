package machine.commands

import kotlin.system.exitProcess

class Exit: MachineCommand {
    override fun execute() {
        exitProcess(0)
    }
}