// https://adventofcode.com/2020/day/4

val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

var validPassports = 0
var currentInfo = ""
while(true) {
    var line = readLine()
    if (line.isNullOrEmpty()) {
        validPassports += if (isValid(currentInfo)) { 1 } else { 0 }
        currentInfo = ""
        if (line == null) {
            break
        } else {
            continue
        }
    }
    currentInfo += " $line"
}

println(validPassports)

fun isValid(info: String): Boolean {
    return info.split(" ")
            .map { it.split(":")[0] }
            .containsAll(requiredFields)
}
