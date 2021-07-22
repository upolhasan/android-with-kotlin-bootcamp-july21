import kotlinx.coroutines.*

val job = SupervisorJob()
val customScope = CoroutineScope(Dispatchers.Default + job)

/**
 * Use [customScope] to update the `launch{}` calls so that the exception in the 2nd `launch{}` doesn't cancel siblings
 */
@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking {
    val job = launch { // root coroutine with launch
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