import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

private fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

/**
 * Update [main] to collect the [Flow] returned from [simple]
 */
@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..30) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow

}
