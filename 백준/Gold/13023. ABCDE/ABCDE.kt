private fun dfs(current: Int, depth: Int) {
    if (depth == 5 || result) {
        result = true
        return
    }
    visited[current] = true

    for (index in node[current]) {
        if (!visited[index]) {
            dfs(index, depth + 1)
        }
    }
    visited[current] = false
}

private val node = mutableListOf<MutableList<Int>>()
private val visited = mutableListOf<Boolean>()
private var result = false

fun main() {
    val nm = readln().split(" ").map { it.toInt() }

    repeat(nm[0]) {
        node.add(mutableListOf())
        visited.add(false)
    }

    repeat(nm[1]) {
        val edge = readln().split(" ").map { it.toInt() }
        node[edge[0]].add(edge[1])
        node[edge[1]].add(edge[0])
    }

    for (index in 0 until nm[0]) {
        dfs(index, 1)

        if (result) {
            break
        }
    }
    if (result) {
        println(1)
    } else {
        println(0)
    }
}