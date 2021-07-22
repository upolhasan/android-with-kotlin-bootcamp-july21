import kotlinx.coroutines.*

/**
 * Update [main] so that the exception in the 2nd launch call does not propagate to the parent and cancel all siblings
 */
@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking {
    val job = GlobalScope.launch { // root coroutine with launch
        launch {
            delay(3000)
            println("Something happened...")
        }
        launch {
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException()
        }
    }
    job.join()
}