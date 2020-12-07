// https://adventofcode.com/2020/day/7

import java.util.Queue
import java.util.LinkedList

val regex = """([a-z]+\ [a-z]+)\ bag""".toRegex()
val myBag = "shiny gold"
val mapOfBags = mutableMapOf<String, MutableList<String>>()

generateSequence(::readLine).forEach { rule ->
    val(parent, childen) = parseRule(rule)
    childen.forEach { child ->
        mapOfBags.getOrDefault(child, mutableListOf()).let {
            it.add(parent)
            mapOfBags.put(child, it)
        }
    }
}

println(applicableBags(myBag))

fun parseRule(rule: String): Pair<String, List<String>> {
    return regex.findAll(rule).map { it.groupValues[1] }.toList().let { bags ->
        val parent = bags[0]
        val children = if (!bags[1].equals("no other")) { bags.subList(1, bags.size) } else { listOf() }
        Pair(parent, children)
    }
}

fun applicableBags(bag: String): Int {
    val applicableBags = mutableSetOf<String>()
    val parentQueue: Queue<String> = LinkedList<String>(listOf(bag))

    while (parentQueue.isNotEmpty()) {
        val parent = parentQueue.remove()
        mapOfBags[parent]?.forEach { parentQueue.add(it) }
        applicableBags.add(parent)
    }

    return applicableBags.size - 1
}
