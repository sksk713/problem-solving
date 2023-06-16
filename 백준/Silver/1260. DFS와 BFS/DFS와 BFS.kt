import java.util.*

fun dfs(position: Int) {
    print("$position ")
    visited[position] = true

    for (index in node[position]) {
        if (!visited[index]) {
            dfs(index)
        }
    }
}

fun bfs(position :Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(position)
    visited[position] = true

    while (!queue.isEmpty()) {
        val currentPosition = queue.poll()
        print("$currentPosition ")

        for (index in node[currentPosition]) {
            if (!visited[index]) {
                queue.add(index)
                visited[index] = true
            }
        }
    }
}

private val node = mutableListOf<MutableList<Int>>()
private val visited = mutableListOf<Boolean>()

fun main() {
    val (n, m, start) = readln().split(" ").map { it.toInt() }

    repeat(n + 1) {
        node.add(mutableListOf())
        visited.add(false)
    }

    repeat(m) {
        val edge = readln().split(" ").map { it.toInt() }
        node[edge[0]].add(edge[1])
        node[edge[1]].add(edge[0])
    }
    for (i in 1..n) node[i].sort()

    dfs(start)

    println()
    visited.fill(false)
    bfs(start)
}