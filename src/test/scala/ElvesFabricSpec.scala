import day3.ElvesFabric
import org.scalatest._

class ElvesFabricSpec extends FlatSpec {

  val small = "src/adventofcode/day3/small.txt"
  val official = "src/adventofcode/day3/input.txt"

  "Part1" should "calculates overlapping correctly" in {
    assert(ElvesFabric.part1(small) == 4)
    assert(ElvesFabric.part1(official) == 101469)
  }


}