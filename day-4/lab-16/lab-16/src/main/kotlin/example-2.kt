import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Update main() so that "Hello World!" is printed to the console
 */
private fun main() {
    GlobalScope.launch {
        delay(100)
        print("Hello ")
    }

    println("World!")
}