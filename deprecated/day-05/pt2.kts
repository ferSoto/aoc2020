// https://adventofcode.com/2020/day/5
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.pow

val seatIds = generateSequence(::readLine).toList()
        .map { calculateSeatId(it.substring(0, 7).decode('F', 'B'), it.substring(7).decode('L', 'R')) }
        .sorted()
        .toIntArray()

println(findMissing(seatIds))

// Methods

fun String.decode(low: Char, high: Char): Int {
    var lower = 0f
    var upper = 2f.pow(length) - 1f
    forEach {
        val delta = ceil((upper - lower) / 2f)
        when(it) {
            low -> upper -= delta
            high -> lower += delta
        }
    }
    return lower.toInt()
}

fun calculateSeatId(row: Int, column: Int) = row * 8 + column

fun findMissing(array: IntArray): Int {
    var lower = 0
    var upper = array.size - 1
    var mid = 0
    while (upper - lower > 1) {
        mid = (lower + upper) / 2
        val delta = array[mid] - mid
        if (array[lower] - lower != delta) {
            upper = mid
        } else if (array[upper] - upper != delta) {
            lower = mid
        }
    }
    return array[mid] + 1
}
