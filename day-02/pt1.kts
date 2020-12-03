// https://adventofcode.com/2020/day/2

// Entry sample: 1-3 a: abcde
val validEntries = generateSequence(::readLine).toList()
        .map { it.split("-", ": ", " ")}
        .map { Entry(it[0].toInt(), it[1].toInt(), it[2][0], it[3]) }
        .filter { it.isValid() }

println(validEntries.size)

data class Entry(val min: Int, val max: Int, val char: Char, val password: String)

fun Entry.isValid(): Boolean {
    return password.count { c -> c.equals(char) } in min..max
}