import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Update [main] so that it stops counting after 2 seconds
 */
private fun main() = runBlocking {
    println("Starting to count...")

    val job = launch { countToN(5) }

    println("Done counting")
}

private suspend fun countToN(n: Int) = coroutineScope {
    for (i in 0..n) {
        launch {
            delay(1000L * i)
            println(i)
        }
    }
}