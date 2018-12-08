import scala.collection.mutable
import scala.io.Source

object Frequencies {

  def part1(file: String): Int = Source.fromFile(file).getLines.map(_.toInt).sum

  def part2(file: String): Int = {
    val hist = mutable.HashMap[Int, Boolean]()
    var newSum = 0
    do {
      for (line <- Source.fromFile(file).getLines.map(_.toInt)) {
        newSum += line
        if (hist.get(newSum).isDefined) {
          return newSum
        } else {
          hist.put(newSum, true)
        }
      }
    } while (true)
    0
  }

}