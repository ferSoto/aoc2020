
val expenses = generateSequence(::readLine).toList().map { s -> s.toInt() }.toTypedArray().sorted()

var low = 0
var high = expenses.size - 1

while (low < high) {
    val sum = expenses[low] + expenses[high]
    if (sum == 2020) {
        print(expenses[low] * expenses[high])
        break
    } else if (sum < 2020) {
        low++
    } else {
        high--
    }
}
