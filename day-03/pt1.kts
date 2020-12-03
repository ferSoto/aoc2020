// https://adventofcode.com/2020/day/3

val map = generateSequence(::readLine).toList().toTypedArray()
val width: Int = map[0].length
val height: Int = map.size

var x: Int = 0

var trees = 0
for (y in 0.. height - 1) {
    trees += if (map[y][x] == '#') { 1 } else { 0 }
    x = (x + 3) % width
}

println(trees)
