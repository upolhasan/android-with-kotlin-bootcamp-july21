import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

private fun programmingLanguages(): Flow<String> = flow { // flow builder
    listOf("C++", "Rust", "Java", "Javascript", "Go", "Kdotlin").forEach {
        delay(1000)
        emit(it)
    }
}

/**
 * Update [main] to collect the [Flow] returned from [programmingLanguages] and filter all values except "Kotlin" and then print out "Emitted Kotlin" once collection is finished
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

    // collect programmingLanguages()
}
