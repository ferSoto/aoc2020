// https://adventofcode.com/2020/day/5
import kotlin.math.ceil
import kotlin.math.max
import kotlin.math.pow

var maxSeatId = 0
generateSequence(::readLine).forEach {
    val seatId = calculateSeatId(it.substring(0, 7).decode('F', 'B'), it.substring(7).decode('L', 'R'))
    maxSeatId = max(maxSeatId, seatId)
}

println(maxSeatId)

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
