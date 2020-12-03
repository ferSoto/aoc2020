// https://adventofcode.com/2020/day/1#part2

val expenses = generateSequence(::readLine).toList().map { s -> s.toInt() }.toTypedArray().sorted()

var low = 0
for (low in 0..expenses.size - 1) {
    var middle = low + 1
    var high = expenses.size - 1
    while (middle < high) {
        val sum = expenses[low] + expenses[middle] + expenses[high]
        if (sum == 2020) {
            print(expenses[low] * expenses[middle] * expenses[high])
            break
        } else if (sum < 2020) {
            middle++
        } else {
            high--
        }
    }
}