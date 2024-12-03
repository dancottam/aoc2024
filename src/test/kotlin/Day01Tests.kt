import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Tests {

    private val input = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """.trimIndent()

    private val day1 = Day1(input.lines())

    @Test
    fun `Sort lists`() {
        val (first, second) = day1.sortLists()

        assertThat(first).isEqualTo(listOf(1, 2, 3, 3, 3, 4))
        assertThat(second).isEqualTo(listOf(3, 3, 3, 4, 5, 9))
    }

    @Test
    fun `Find difference`() {
        val diff = day1.solvePart1()

        assertThat(diff).isEqualTo(11)
    }

    @Test
    fun `Count occurrences`() {
        val score = day1.occurrences()

        assertThat(score).isEqualTo(listOf(3, 1, 0, 0, 3, 3))
    }

    @Test
    fun `Solve part 2`() {
        val result = day1.solvePart2()

        assertThat(result).isEqualTo(31)
    }
}