# 🖥 Lab 16 Hints: Writing Asynchronous Code with Coroutines

## 💡 Helpful Resources
- [Coroutine Examples Repo](https://github.com/Kotlin/kotlinx.coroutines/tree/master/kotlinx-coroutines-core/jvm/test/guide)
- [Kotlin Coroutines Guide](https://kotlinlang.org/docs/coroutines-overview.html)
- [Coroutines Basics](https://kotlinlang.org/docs/coroutines-basics.html)
- [Flow](https://kotlinlang.org/docs/flow.html)

## 💡 Example 0
Suspending functions must be called from a coroutine or other suspending function.
The easiest way to launch a new coroutine is `GlobalScope.launch{}`

## 💡 Example 1
When you first run `main()` it runs fine, but nothing is printed out.
Why?

It's because the coroutine isn't finished running before `main()` completes.
The coroutine doesn't block execution of the calling thread.

Add a `Thread.sleep(1000)` to the bottom of `main()` to give the coroutine time to finish

## 💡 Example 3
Notice that we no longer need to call `Thread.sleep()`.
Because `runBlocking{}` launches a new coroutine, we are within a coroutine scope and can use delay() to suspend the coroutine long enough to let `hello()` complete

## 💡 Example 5
`launch{}` returns a `Job` which can be used to cancel a coroutine or to suspend execution until the `Job` is complete.
A `Job` is not complete, until all child coroutines have finished.

So, if we launch multiple coroutines inside of the initial `launch{}` call, we can suspend until all children have completed by calling `join()` on the parent `Job`

## 💡 Example 6
If we have a reference to a coroutine's `Job` we can cancel that `Job` by calling `Job.cancel()`