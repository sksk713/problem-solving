private var n = 0
private var list = mutableListOf<Int>()
private var sum = 0
private var result = 0

fun main() {
    n = readln().toInt()
    list = readln()
        .split(" ")
        .map { it.toInt() }
        .sorted()
        .toMutableList()

    sum = 0
    result = list.sumOf {
        sum += it
        sum
    }
    println(result)
}