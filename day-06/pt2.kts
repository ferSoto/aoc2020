// https://adventofcode.com/2020/day/6

var sum = 0
var lineCount = 0
val qMap = HashMap<Char, Int>()
while (true) {
    val line = readLine()
    if (line == null) {
        sum += qMap.filter { it.value == lineCount }.size
        break
    } else if (line.isEmpty()) {
        sum += qMap.filter { it.value == lineCount }.size
        qMap.clear()
        lineCount = 0
    } else {
        lineCount ++
        line.forEach { qMap.put(it, qMap.getOrDefault(it, 0) + 1) }
    }
}
println(sum)
