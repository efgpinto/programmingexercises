package day5

import scala.io.Source

object AlchemicalReduction extends App {

  assert(reducible('a', 'A'))
  assert(reducible('B', 'b'))
  assert(!reducible('a', 'a'))
  assert(!reducible('a', 'B'))

  val result1 = part1("src/adventofcode/day5/small.txt")
  assert(result1 == 10, s"Result: $result1")

  val result2 = part1("src/adventofcode/day5/input.txt")
  assert(result2 == 11310, s"Result: $result2")

  val result3 = part2("src/adventofcode/day5/small.txt")
  assert(result3 == 4, s"Result: $result3")

  val result4 = part2("src/adventofcode/day5/input.txt")
  assert(result4 == 6020, s"Result: $result4")

  def reducible(c1: Char, c2: Char): Boolean = {
    (c1.isUpper && c2.isLower && c1.toLower == c2) ||
      (c2.isUpper && c1.isLower && c2.toLower == c1)
  }

  def reduce(str: Stream[Char], ignore: Option[Char] = None): String = str.foldLeft("") { (queue, char) =>
    if (queue.isEmpty && char.toLower != ignore.getOrElse('0')) char.toString
    else if (queue.isEmpty && char.toLower == ignore.getOrElse('0')) ""
    else {
      (char, queue.head) match {
        case (c1, _) if c1.toLower == ignore.getOrElse('0') => queue
        case (c1, c2) if reducible(c1, c2) => queue.tail
        case (c1, _) => c1 + queue
      }
    }
  }

  def part1(file: String): Int = {
    reduce(Source.fromFile(file).toStream).trim.length
  }

  def part2(file: String): Int = {
    val chars = 'a' to 'z'

    chars.foldLeft(Map.empty[Char, Int]) { (acum, charToIgnore) =>
      val charStream = Source.fromFile(file).toStream
      val reduced = reduce(charStream, Some(charToIgnore))
      //println(s"Ignoring $charToIgnore -> $reduced")
      acum + (charToIgnore -> reduced.trim.length)
    }.values.min
  }

}