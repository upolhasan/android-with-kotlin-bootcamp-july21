import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    countToN(3)
    println("Done counting")
}

/**
 * Update [countToN] so it sequentially prints out all numbers from 0 to [n]
 */
private suspend fun countToN(n: Int) = coroutineScope {
    println("Starting to count...")
}