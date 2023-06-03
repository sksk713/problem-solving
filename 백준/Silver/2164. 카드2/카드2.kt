private fun solve(deque: ArrayDeque<Int>) {
    while (deque.size != 1) {
        deque.removeFirst()
        deque.addLast(deque.removeFirst())
    }
    println(deque.first())
}

fun main() {
    val n = readln().toInt()
    val deque = ArrayDeque<Int>()
    var initInt = 1
    repeat(n) {
        deque.addLast(initInt++)
    }
    solve(deque)
}