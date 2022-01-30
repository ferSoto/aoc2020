// https://adventofcode.com/2020/day/3#part2

val map = generateSequence(::readLine).toList().toTypedArray()
val width: Int = map[0].length
val height: Int = map.size

val slopes = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
println(slopes)
var result: Long = 1

slopes.forEach { (right, down) ->
    var x = 0
    var trees = 0
    for (y in 0.. height - 1 step down) {
        trees += if (map[y][x] == '#') { 1 } else { 0 }
        x = (x + right) % width
    }
    result *= trees
}

println(result)
