// https://adventofcode.com/2020/day/7#part2

import java.util.Queue
import java.util.LinkedList

val parentRegex = """([a-z]+\ [a-z]+)\ bag""".toRegex()
val childRegex = """([0-9]+)\ ([a-z]+\ [a-z]+)\ bag""".toRegex()
val mapOfBags = mutableMapOf<String, MutableList<Pair<Int, String>>>()

generateSequence(::readLine).forEach { rule ->
    val(parent, childen) = parseRule(rule)
    childen.forEach { child ->
        mapOfBags.getOrDefault(parent, mutableListOf()).let {
            it.add(child)
            mapOfBags.put(parent, it)
        }
    }
}

println(numberOfBagsInside("shiny gold"))

fun parseRule(rule: String): Pair<String, List<Pair<Int, String>>> {
    val parent = parentRegex.find(rule)!!.groupValues[1]
    val children = childRegex.findAll(rule).toList().map {
        val numberOfBags = it.groupValues[1].toInt()
        val bagType = it.groupValues[2]
        Pair(numberOfBags, bagType)
    }
    return Pair(parent, children)
}

fun numberOfBagsInside(rootBag: String): Int {
    val childQueue: Queue<Pair<Int, String>> = LinkedList<Pair<Int, String>>(listOf(Pair(1, rootBag)))
    var ans = 0
    while (childQueue.isNotEmpty()) {
        val (numOfBags, parent) = childQueue.remove()
        ans += numOfBags
        mapOfBags[parent]?.let { bags ->
            bags.forEach { (multiplier, type) ->
                childQueue.add(Pair(numOfBags * multiplier, type))
            }
        }
    }
    return ans - 1
}
