import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private suspend fun getValue1(): Int {
    delay(3000)
    return 2
}

private suspend fun getValue2(): Int {
    delay(100)
    return 2
}

/**
 * Using `async{}`, update [main] to add the results of [getValue1] and [getValue2] then print the result
 */
private fun main() = runBlocking {
    println("Starting to add...")

    println("The result was ...")
}