
fun main() {
    val entries = inputLines(2)
        .map { it.split("-", ": ", " ")}
        .map { Entry(it[0].toInt(), it[1].toInt(), it[2][0], it[3]) }

    // First part
    println("First Part: " + entries.filter(Entry::fulfillFirstRule).size)

    // Second part
    println("Second Part: " + entries.filter(Entry::fulfillSecondRule).size)
}

fun Entry.fulfillFirstRule(): Boolean {
    return password.count { c -> c.equals(char) } in first..second
}

fun Entry.fulfillSecondRule(): Boolean {
    return (password[first - 1] == char).xor(password[second - 1] == char)
}

data class Entry(val first: Int, val second: Int, val char: Char, val password: String)
