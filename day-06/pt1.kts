// https://adventofcode.com/2020/day/6

var sum = 0
val qSet = HashSet<Char>()
while (true) {
    val line = readLine()
    if (line == null) {
        sum += qSet.size
        break
    } else if (line.isEmpty()) {
        sum += qSet.size
        qSet.clear()
    } else {
        line.map { qSet.add(it) }
    }
}
println(sum)
