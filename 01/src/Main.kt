/**
 * Advent of Code: Day 1
 */

fun main() {
    val lines = inputLines(1)
        .map { it.toInt() }

    // First part

    findTwoValues(lines.associateWith { 2020 - it })?.let {
        println("First part: " + it.multiply())
    }

    // Second part

    findThreeValues(lines)?.let {
        println("Second part: " + it.multiply())
    }
}

fun findTwoValues(map: Map<Int, Int>): List<Int>? {
    return map.firstNotNullOfOrNull { (k, v) -> if (map.contains(v)) listOf(k, v) else null }
}

fun findThreeValues(numbers: List<Int>): List<Int>? {
    return numbers.firstNotNullOfOrNull { currentNumber ->
        findTwoValues(numbers.associateWith { 2020 - currentNumber - it })?.let { it + currentNumber }
    }
}

fun List<Int>.multiply(): Int {
    return this.fold(1) { acc, v -> acc * v }
}
