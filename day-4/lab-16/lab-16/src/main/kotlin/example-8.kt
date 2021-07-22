import kotlinx.coroutines.*

private suspend fun getValue1(): Int {
    delay(3000)
    return 2
}

private suspend fun getValue2(): Int {
    delay(100)
    return 2
}

/**
 * Using `withContext()` update [main] to print out the result of [getValue1] and [getValue2]
 */
private fun main() = runBlocking {
    println("Starting to add...")

    println("The result was ...")
}