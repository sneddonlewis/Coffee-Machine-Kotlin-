package machine

import machine.commands.Buy
import machine.commands.Fill
import machine.commands.Take

class CoffeeMachineConsole(
    private val machine: CoffeeMachine,
    private val interaction: UserInteraction,
    private val purse: Money,
    ) {

    fun run(): Unit {
        displayMachineContents()
        when(interaction.askForString("Write action (buy, fill, take):")) {
            "buy" -> Buy(machine, interaction, purse).execute()
            "fill" -> Fill(machine, interaction).execute()
            "take" -> Take(machine, interaction, purse).execute()
        }
        displayMachineContents()
    }

    private fun displayMachineContents(): Unit = this.interaction.write(this.machine)

//    private fun take(): Unit {
//        val movedAmount = this.machine.takeAllMoney(purse);
//        this.interaction.write("I gave you $$movedAmount")
//    }

//    private fun buy(): Unit {
//        when (interaction.askForInt("What do you want to buy: 1 - espresso, 2 - latte, 3 - cappuccino:")) {
//            1 -> this.machine.buy(CoffeeType.ESPRESSO, purse)
//            2 -> this.machine.buy(CoffeeType.LATTE, purse)
//            3 -> this.machine.buy(CoffeeType.CAPPUCCINO, purse)
//        }
//    }

//    private fun fill(): Unit {
//        val water = interaction.askForInt(makeFillString("ml of water"))
//        val milk = interaction.askForInt(makeFillString("ml of milk"))
//        val beans = interaction.askForInt(makeFillString("grams of coffee beans"))
//        val cups = interaction.askForInt(makeFillString("disposable cups"))
//
//        this.machine.fill(water, milk, beans, cups)
//    }
//
//    private fun makeFillString(fillWith: String): String =
//        "Write how many $fillWith you want to add:"
}