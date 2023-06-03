fun solve(n: Int): Int {
    var rightPoint = n - 1
    var leftPoint = n - 1
    var sum = rightPoint
    var count = 1

    while (rightPoint != 0) {
        if (sum < n) {
            sum += --leftPoint
        } else if (sum > n) {
            sum -= rightPoint--
        } else {
            count++
            sum -= rightPoint--
        }
    }
    return count
}

fun main() {
    val n = readln().toInt()

    println(solve(n))
}