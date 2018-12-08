package day3

import scala.collection.mutable
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
    for (i <- x until x+xLen; j <- y until y+yLen) yield s"$i,$j"
  }.toList

  def part2(file: String): Int = {
    val postHist = mutable.HashMap[String, Int]()

    val posByLine = (for (line <- Source.fromFile(file).getLines) yield {
      val pattern = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)".r
      val pattern(i, x1, y1, xOffset, yOffset) = line
      i -> generatePositions(x1.toInt, y1.toInt, xOffset.toInt, yOffset.toInt)
    }).toMap

    for((_, positions) <- posByLine; p <- positions)
      postHist.put(p, postHist.getOrElseUpdate(p, 0) + 1)

    posByLine
      .filter { tuple => tuple._2.forall(postHist(_) == 1) }
      .head._1.toInt
  }

}