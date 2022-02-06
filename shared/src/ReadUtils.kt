/**
 * File with utility methods shared across multiple days
 */

import java.io.File

fun lines(path: String): List<String> {
    return File(path).readLines()
}

fun exampleLines(day: Int): List<String> {
    return lines("${day.withPad()}/input/example.txt")
}

fun inputLines(day: Int): List<String> {
    return lines("${day.withPad()}/input/input.txt")
}

private fun Int.withPad(): String {
    return this.toString().padStart(2, '0')
}
