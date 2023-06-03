import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val priorityQueue = PriorityQueue<Int>(Comparator { a, b ->
        when {
            abs(a) > abs(b) -> 1
            abs(a) < abs(b) -> -1
            a > b -> 1
            a < b -> -1
            else -> 0
        }
    })

    repeat(n) {
        val x = readln().toInt()

        if (x == 0) {
            if (priorityQueue.isEmpty()) {
                println(0)
            } else {
                println(priorityQueue.poll())
            }
        } else {
            priorityQueue.add(x)
        }
    }
}