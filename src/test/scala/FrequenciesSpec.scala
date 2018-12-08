import org.scalatest._

class FrequenciesSpec extends FlatSpec {

  val filename = "src/adventofcode/day1/input.txt"

  "Part1" should "sum frequencies" in {
    val freq = Frequencies.part1(filename)
    assert(freq == 493)
  }

  "Part2" should "sum frequencies in loop until the sum repeats" in {
    val freq = Frequencies.part2(filename)
    assert(freq == 413)
  }

}