package day6

import scala.io.Source
import scala.util.Try

object ChronalCoordinates extends App {

  assert(calculateTaxicab((1,1), (1,6)) == 5)
  assert(calculateTaxicab((3,1), (1,2)) == 3)

  assert(findClosest((1,1), List((1,3), (3,5), (5,5))) == 0)
  assert(findClosest((5,4), List((1,3), (3,5), (5,5))) == 2)
  assert(findClosest((4,4), List((1,3), (3,5), (5,5))) == -1)
  assert(findClosest((4,9), List((1,3), (5,5), (8,9))) == 2)

  assert(matToPos((0,0), 2, 4) == 0)
  assert(matToPos((0,1), 2, 4) == 1)
  assert(matToPos((1,0), 2, 4) == 4)
  assert(matToPos((1,2), 2, 4) == 6)
  assert(matToPos((1,3), 2, 4) == 7)
  assert(matToPos((0,0), 4, 2) == 0)
  assert(matToPos((0,1), 4, 2) == 1)
  assert(matToPos((1,0), 4, 2) == 2)
  assert(matToPos((2,1), 4, 2) == 5)
  assert(matToPos((3,1), 4, 2) == 7)
  assert(matToPos((4,4), 5, 5) == 24)

  assert(isAtLimit(0, 5, 5))
  assert(isAtLimit(1, 5, 5))
  assert(isAtLimit(2, 5, 5))
  assert(isAtLimit(3, 5, 5))
  assert(isAtLimit(4, 5, 5))
  assert(isAtLimit(5, 5, 5))
  assert(!isAtLimit(6, 5, 5))
  assert(!isAtLimit(7, 5, 5))
  assert(!isAtLimit(8, 5, 5))
  assert(isAtLimit(9, 5, 5))
  assert(isAtLimit(10, 5, 5))
  assert(!isAtLimit(11, 5, 5))
  assert(!isAtLimit(12, 5, 5))
  assert(!isAtLimit(13, 5, 5))
  assert(isAtLimit(14, 5, 5))
  assert(isAtLimit(15, 5, 5))
  assert(!isAtLimit(16, 5, 5))
  assert(!isAtLimit(17, 5, 5))
  assert(!isAtLimit(18, 5, 5))
  assert(isAtLimit(19, 5, 5))
  assert(isAtLimit(20, 5, 5))
  assert(isAtLimit(21, 5, 5))
  assert(isAtLimit(22, 5, 5))
  assert(isAtLimit(23, 5, 5))
  assert(isAtLimit(24, 5, 5))

  val pattern = "(\\d+), (\\d+)".r

  val result1 = part1("src/adventofcode/day6/small.txt")
  assert(result1 == 17, s"Result: $result1")

  val result2 = part1("src/adventofcode/day6/input.txt")
  assert(result2 == 3290, s"Result: $result2")

  val result3 = part2("src/adventofcode/day6/small.txt", 32)
  assert(result3 == 16, s"Result: $result3")

  val result4 = part2("src/adventofcode/day6/input.txt", 10000)
  assert(result4 == 45602, s"Result: $result4")

  def part1(file: String): Int = {
    var maxX, maxY = 0

    val tuples = Source.fromFile(file).getLines().map { line =>
      val pattern(x, y) = line
      maxX = if (x.toInt > maxX) x.toInt else maxX
      maxY = if (y.toInt > maxY) y.toInt else maxY
      (x.toInt, y.toInt)
    }.toList

    val closestPos = (for (x <- 0 to maxX; y <- 0 to maxY) yield (x,y))
      .toStream.foldLeft(List.empty[Int]) { (acum, pos) => acum :+ findClosest(pos, tuples) }

    val notInfinite = (0 until maxX * maxY).toStream.foldLeft(tuples.indices.toSet[Int]) { (indexes, pos) =>
      val closerToPos = closestPos(pos)
      if (indexes.contains(closerToPos) && isAtLimit(pos, maxX+1, maxY+1))
        indexes.filter(_ != closerToPos)
      else
        indexes
    }

    notInfinite.map( i => closestPos.count(_ == i)).max
  }

  def part2(file: String, maxDist: Int): Int = {
    var maxX, maxY = 0

    val tuples = Source.fromFile(file).getLines().map { line =>
      val pattern(x, y) = line
      maxX = if (x.toInt > maxX) x.toInt else maxX
      maxY = if (y.toInt > maxY) y.toInt else maxY
      (x.toInt, y.toInt)
    }.toList

    val closestDist = (for (x <- 0 to maxX; y <- 0 to maxY) yield (x,y))
      .toStream.foldLeft(List.empty[Int]) { (acum, pos) => acum :+ distToPoints(pos, tuples) }

    closestDist.count(_ < maxDist)
  }

  def distToPoints(pos: (Int, Int), points: List[(Int, Int)]): Int = {
    points
      .map { t2 => calculateTaxicab(pos, t2) }
      .sum
  }


  def isAtLimit(pos: Int, maxX: Int, maxY: Int): Boolean = {
    (pos >= 0 && pos < maxY) ||
      pos % maxY == 0 ||
      (pos % maxY) == maxY-1 ||
      (pos >= (maxX * (maxY-1)) && pos < maxX * maxY)
  }

  def matToPos(mat: (Int, Int), maxX: Int, maxY: Int) = {
    require(mat._1 < maxX)
    require(mat._2 < maxY)

    mat._1 * maxY + mat._2
  }

  def findClosest(pos: (Int, Int), points: List[(Int, Int)]): Int = {
    val dists = points.zipWithIndex.map { case (t2, i) => i -> calculateTaxicab(pos, t2) }
    val minValue = dists.minBy(_._2)._2
    val closest = dists.filter(_._2 == minValue)

    if (closest.size > 1) -1
    else closest.head._1
  }

  def calculateTaxicab(t1: (Int, Int), t2: (Int, Int)): Int = Math.abs(t1._1 - t2._1) + Math.abs(t1._2 - t2._2)


}