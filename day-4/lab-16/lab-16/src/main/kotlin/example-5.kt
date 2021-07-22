import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Using a [Job], update [main] so that "Done counting" is printed out last
 */
private fun main() = runBlocking {
    println("Starting to count...")

    launch { countToN(3) }

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