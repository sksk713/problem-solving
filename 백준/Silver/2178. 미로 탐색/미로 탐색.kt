import java.util.*

fun bfs(n: Int, m: Int) {
    val queue: Queue<Node> = LinkedList()
    queue.add(Node(0, 0))

    while (!queue.isEmpty()) {
        val currentPosition = queue.poll()

        for (index in 0 until 4) {
            val nx = currentPosition.x + dx[index]
            val ny = currentPosition.y + dy[index]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] != 1 || miro[nx][ny] == 0) {
                continue
            }
            queue.add(Node(nx, ny))
            visited[nx][ny] = visited[currentPosition.x][currentPosition.y] + 1

            if (nx == n - 1 && ny == m - 1) {
                println(visited[nx][ny])
                break
            }
        }
    }
}

private val miro = mutableListOf<MutableList<Int>>()
private val visited = mutableListOf<MutableList<Int>>()
private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    repeat(n) { x ->
        miro.add(mutableListOf())
        visited.add(mutableListOf())
        val input = readln()
        repeat(m) { y ->
            miro[x].add(input[y] - '0')
            visited[x].add(1)
        }
    }
    bfs(n, m)
}

private data class Node(
    val x: Int,
    val y: Int
)