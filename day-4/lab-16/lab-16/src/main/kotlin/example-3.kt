import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


private suspend fun hello() {
    delay(100)
    print("Hello ")
}

/**
 * Update main() so that "Hello World!" is printed to the console
 */
private fun main() = runBlocking {
    launch {
        hello()
    }
    delay(200)
    println("World!")
}