val list = mutableListOf<Node>()

fun main() {
    val n = readln().toInt()

    repeat(n) {
        val input = readln().toInt()
        list.add(Node(input, it))
    }
    list.sort()

    val result = list.withIndex().maxOf { (index, node) ->
        node.index - index
    }
    println(result + 1)
}

data class Node(
    val value: Int,
    val index: Int,
) : Comparable<Node> {

    override fun compareTo(other: Node): Int =
        value.compareTo(other.value)
}