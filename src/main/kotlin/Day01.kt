import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val day1 = Day1(input)
        return day1.solvePart1()
    }

    fun part2(input: List<String>): Int {
        val day1 = Day1(input)
        return day1.solvePart2()
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

class Day1(
    private val input: List<String>,
) {

    fun solvePart1(): Int {
        val (first, second) = sortLists()
        return calculateDiff(first, second)
    }

    fun solvePart2(): Int {
        val lists = createLists()
        val occurrences = occurrences()

        val similarityScores = lists.first.indices.map { lists.first[it] * occurrences[it] }

        return similarityScores.sum()
    }

    fun createLists(): Pair<List<Int>, List<Int>> {
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()

        for (line in input) {
            val (first, second) = line.split("\\s+".toRegex())

            firstList.add(first.toInt())
            secondList.add(second.toInt())
        }
        return Pair(firstList.toList(), secondList.toList())
    }

    fun sortLists(): Pair<List<Int>, List<Int>> {
        val lists = createLists()

        return Pair(lists.first.sorted(), lists.second.sorted())
    }

    private fun calculateDiff(first: List<Int>, second: List<Int>): Int {
        val diffs = mutableListOf<Int>()
        for (i in first.indices) {
            diffs.add((first[i] - second[i]).absoluteValue)
        }
        return diffs.sum()
    }

    fun occurrences(): List<Int> {
        val (first, second) = createLists()
        return first.map { it1 -> second.count { it2 -> it1 == it2 } }
    }
}
