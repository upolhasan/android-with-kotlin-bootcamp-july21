import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Update main() so that "Hello World!" is printed to the console
 */
private fun main() {
    GlobalScope.launch {
        helloWorld()
    }
}