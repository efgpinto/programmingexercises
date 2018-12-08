package day3

import scala.io.Source

object ElvesFabric {

  def part1(file: String): Int = {
    val posByLine = for (line <- Source.fromFile(file).getLines) yield {
      val pattern = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)".r
      val pattern(_, x1, y1, xOffset, yOffset) = line
      generatePositions(x1.toInt, y1.toInt, xOffset.toInt, yOffset.toInt)
    }

    posByLine
      .flatten.toList
      .groupBy(identity)
      .collect { case (x, List(_,_,_*)) => x }
      .size
  }

  def generatePositions(x: Int, y: Int, xLen: Int, yLen: Int): List[String] = {
    for (i <- x until x+xLen; j <- y until y+yLen) yield s"$i-$j"
  }.toList

}