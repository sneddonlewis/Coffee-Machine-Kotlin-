package machine

import java.io.PrintStream
import java.util.Scanner

open class UserInteraction(private val sc: Scanner, private val out: PrintStream) {

    fun askForInt(prompt: String): Int {
        out.println(prompt)
        return sc.nextInt()
    }

    fun askForString(prompt: String): String {
        out.println(prompt)
        return sc.nextLine()
    }

    fun write(message: Any): Unit {
        out.println(message)
    }
}

class ConsoleInteraction : UserInteraction(Scanner(System.`in`), System.out)