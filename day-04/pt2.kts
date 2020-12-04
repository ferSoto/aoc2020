// https://adventofcode.com/2020/day/4#part2

val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
val validEyeColors = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

var validPassports = 0
var currentInfo = ""
while(true) {
    var line = readLine()
    if (line.isNullOrEmpty()) {
        validPassports += if (isValid(currentInfo.trim())) { 1 } else { 0 }
        currentInfo = ""
        if (line == null) {
            break
        } else {
            continue
        }
    }
    currentInfo += "$line "
}

println(validPassports)

// Methods

fun isValid(info: String): Boolean {
    val fields = info.split(" ").map { it.split(':') }
    return fields.map { it[0] }.containsAll(requiredFields)
            && fields.all { isValidField(it[0], it[1]) }
}

fun isValidField(field: String, value: String) = when(field) {
    "byr" -> value.intBetween(1920, 2002)
    "iyr" -> value.intBetween(2010, 2020)
    "eyr" -> value.intBetween(2020, 2030)
    "hgt" -> value.isValidHeight()
    "hcl" -> value.isValidHexColor()
    "ecl" -> value.isValidEyeColor()
    "pid" -> value.isValidPassportNumber()
    else -> true
}

fun String.intBetween(min: Int, max: Int): Boolean {
    return toInt() in min..max
}

fun String.isValidHeight() = when(substring(length - 2)) {
    "cm" -> substring(0, length - 2).toInt() in 150..193
    "in" -> substring(0, length - 2).toInt() in 59..76
    else -> false
}

fun String.isValidHexColor(): Boolean {
    return startsWith('#') && substring(1).all { it in ('a'..'f').union('A'..'F').union('0'..'9') }
}

fun String.isValidEyeColor(): Boolean {
    return this in validEyeColors
}

fun String.isValidPassportNumber(): Boolean {
    return length == 9 && all { it.isDigit() }
}
