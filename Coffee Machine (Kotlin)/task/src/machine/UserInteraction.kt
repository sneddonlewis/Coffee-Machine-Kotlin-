package machine

import java.io.PrintStream
import java.util.Scanner

open class UserInteraction(private val sc: Scanner, private val out: PrintStream) {

    fun askForInt(prompt: String): Int {
        out.println(prompt)
        return sc.nextInt()
    }

    fun write(message: Any): Unit {
        out.println(message)
    }
}

class ConsoleInteraction : UserInteraction(Scanner(System.`in`), System.out)